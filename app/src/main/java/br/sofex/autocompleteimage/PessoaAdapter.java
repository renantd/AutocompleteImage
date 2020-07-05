package br.sofex.autocompleteimage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PessoaAdapter extends ArrayAdapter<Pessoa> {

    private Context mContext;
    private int resourceId;
    private List<Pessoa> items, tempItems, suggestions;

    public PessoaAdapter(@NonNull Context context, int resourceId, ArrayList<Pessoa> items) {
        super(context, resourceId, items);
        this.items = items;
        this.mContext = context;
        this.resourceId = resourceId;
        tempItems = new ArrayList<>(items);
        suggestions = new ArrayList<>();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        try {
            if (convertView == null) {
                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                view = inflater.inflate(resourceId, parent, false);
            }
            Pessoa Pessoa = getItem(position);
            TextView name = (TextView) view.findViewById(R.id.tvCustomer);
            TextView tvIdade = (TextView) view.findViewById(R.id.tv_Idade);
            TextView tvEmail = (TextView) view.findViewById(R.id.tv_email);
            ImageView imageView = view.findViewById(R.id.ivCustomerImage);
            //imageView.setImageResource(Pessoa.getImage());

            imageView.setImageBitmap(CircularImagem(BitmapFactory.decodeResource(mContext.getResources(),Pessoa.getImage())));
            tvIdade.setText(Pessoa.getIdade().toString()+" anos");
            tvEmail.setText(Pessoa.getEmail());
            name.setText(Pessoa.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
    @Nullable
    @Override
    public Pessoa getItem(int position) {
        return items.get(position);
    }
    @Override
    public int getCount() {
        return items.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @NonNull
    @Override
    public Filter getFilter() {
        return PessoaFilter;
    }
    private Filter PessoaFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            Pessoa Pessoa = (Pessoa) resultValue;
            return Pessoa.getName();
        }
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            if (charSequence != null) {
                suggestions.clear();
                for (Pessoa Pessoa: tempItems) {
                    if (Pessoa.getName().toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        suggestions.add(Pessoa);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            ArrayList<Pessoa> tempValues = (ArrayList<Pessoa>) filterResults.values;
            if (filterResults != null && filterResults.count > 0) {
                clear();
                for (Pessoa PessoaObj : tempValues) {
                    add(PessoaObj);
                }
                notifyDataSetChanged();
            } else {
                clear();
                notifyDataSetChanged();
            }
        }
    };

    protected Bitmap CircularImagem(Bitmap srcBitmap) {
        // Calculate the circular bitmap width with border
        int squareBitmapWidth = Math.min(srcBitmap.getWidth(), srcBitmap.getHeight());

        // Initialize a new instance of Bitmap
        Bitmap dstBitmap = Bitmap.createBitmap(
                squareBitmapWidth, // Width
                squareBitmapWidth, // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        // Initialize a new Canvas to draw circular bitmap
        Canvas canvas = new Canvas(dstBitmap);

        // Initialize a new Paint instance
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        // Initialize a new Rect instance
        Rect rect = new Rect(0, 0, squareBitmapWidth, squareBitmapWidth);

        // Initialize a new RectF instance
        RectF rectF = new RectF(rect);
        // Draw an oval shape on Canvas
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        // Calculate the left and top of copied bitmap
        float left = (squareBitmapWidth-srcBitmap.getWidth())/2;
        float top = (squareBitmapWidth-srcBitmap.getHeight())/2;

        // Make a rounded image by copying at the exact center position of source image
        canvas.drawBitmap(srcBitmap, left, top, paint);

        // Free the native object associated with this bitmap.
        srcBitmap.recycle();

        // Return the circular bitmap
        return dstBitmap;
    }

}
