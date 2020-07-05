package br.sofex.autocompleteimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    private ArrayList<Pessoa> pessoaArrayList;
    private AppCompatAutoCompleteTextView autoTextViewCustom;
    private TextView tv_User;
    private PessoaAdapter pessoaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //customers = new ArrayList<>();
        //customers = populateCustomerData(customers);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        tv_User = findViewById(R.id.tv_User);
        // Each row in the list stores country name, currency and flag
        autoCompleteTextView.setText(null);
          //SetAutocomplete(autoCompleteTextView);



        List<String> listapessoa = new ArrayList<>();
        listapessoa.add(DataTo_List(R.drawable.molde_antes,"Bia Munstein","06/05/1981","woazaki@gmail.com"));
        listapessoa.add(DataTo_List(R.drawable.melanie_lynskey,"melanie_lynskey","16/05/1977","woazaki@gmail.com"));
        listapessoa.add(DataTo_List(R.drawable.melanie_lynskey2,"melanie_lynskey2","16/05/1977","woazaki@gmail.com"));
        listapessoa.add(DataTo_List(R.drawable.emmanuele_vaugier,"Emmanuele Vaugier","23/06/1976","woazaki@gmail.com"));
        listapessoa.add(DataTo_List(R.drawable.denise_richards2,"Denise Richards","17/02/1971","woazaki@gmail.com"));
        listapessoa.add(DataTo_List(R.drawable.eu_de_terno,"Renan Costa e Silva","06/08/1986","woazaki@gmail.com"));
        listapessoa.add(DataTo_List(R.drawable.marin_hinkle,"Marin Hinkle","23/03/1966","woazaki@gmail.com"));
        setDataPessoa(listapessoa);

        /*setDataPessoa(R.drawable.molde_antes, "molde_antes","06/05/1981","woazaki@gmail.com");
        setDataPessoa(R.drawable.melanie_lynskey, "melanie_lynskey","16/05/1977","woazaki@gmail.com");

        setDataPessoa(R.drawable.melanie_lynskey2, "melanie_lynskey","16/05/1977","woazaki@gmail.com");
        setDataPessoa(R.drawable.emmanuele_vaugier, "Emmanuele Vaugier","23/06/1976","woazaki@gmail.com");
        setDataPessoa(R.drawable.denise_richards2, "Denise Richards","17/02/1971","woazaki@gmail.com");

        setDataPessoa(R.drawable.eu_de_terno, "Renan Costa e Silva","06/08/1986","woazaki@gmail.com");
        setDataPessoa(R.drawable.marin_hinkle, "Marin Hinkle","23/03/1966","woazaki@gmail.com");*/

        /*pessoaArrayList = new ArrayList<>();
        try {
            pessoaArrayList.add(new Pessoa(R.drawable.antes,             "Bia Munstein",CalculaIdadeAnos("06/08/1979"),"woazaki@gmail.com"));
            pessoaArrayList.add(new Pessoa(R.drawable.molde_antes,       "molde_antes",CalculaIdadeAnos("06/05/1981"),"woazaki@gmail.com"));
            pessoaArrayList.add(new Pessoa(R.drawable.melanie_lynskey,   "melanie_lynskey",CalculaIdadeAnos("16/05/1977"),"woazaki@gmail.com"));
            pessoaArrayList.add(new Pessoa(R.drawable.melanie_lynskey2,  "melanie_lynskey",CalculaIdadeAnos("16/05/1977"),"woazaki@gmail.com"));
            pessoaArrayList.add(new Pessoa(R.drawable.emmanuele_vaugier, "Emmanuele Vaugier",CalculaIdadeAnos("23/06/1976"),"woazaki@gmail.com"));
            pessoaArrayList.add(new Pessoa(R.drawable.denise_richards2,  "Denise Richards",CalculaIdadeAnos("17/02/1971"),"woazaki@gmail.com"));
            pessoaArrayList.add(new Pessoa(R.drawable.eu_de_terno,       "Renan Costa e Silva",CalculaIdadeAnos("06/08/1986"),"woazaki@gmail.com"));
            pessoaArrayList.add(new Pessoa(R.drawable.marin_hinkle,      "Marin Hinkle",CalculaIdadeAnos("23/03/1966"),"woazaki@gmail.com"));
        } catch (ParseException e) {
            Toast.makeText(this, "Error : " + e, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        pessoaAdapter = new PessoaAdapter(this, R.layout.customer_row, pessoaArrayList);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(pessoaAdapter);
        // handle click event and set desc on textview
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pessoa pessoa = (Pessoa) adapterView.getItemAtPosition(i);
                //fruitDesc.setText(pessoa.getName());
                tv_User.setText(pessoa.getName());
                Log.e("App1"," Pessoa : "+pessoa.getName());
            }
        });*/

    }

    public String DataTo_List( Integer Imagem , String Nome , String Data , String Email) {
        return  "<Foto>"+Imagem+"</Foto>"+"<Nome>"+Nome+"</Nome>"+"<Data>"+Data+"</Data>"+"<Email>"+Email+"</Email>";
    }

    public void setDataPessoa( List<String> ListPessoa){

        for(String str : ListPessoa){
            String FotoString = str.substring(str.indexOf("<Foto>") + 6,str.indexOf("</Foto>"));
            String Nome       = str.substring(str.indexOf("<Nome>") + 6,str.indexOf("</Nome>"));
            String Data       = str.substring(str.indexOf("<Data>") + 6,str.indexOf("</Data>"));
            String Email      = str.substring(str.indexOf("<Email>") + 7,str.indexOf("</Email>"));

            Log.e("App1", "Foto : "+FotoString);
            Log.e("App1", "Nome : "+Nome);
            Log.e("App1", "Data : "+Data);
            Log.e("App1", "Email : "+Email);
        }

        pessoaArrayList = new ArrayList<>();
        try {
            for(String str : ListPessoa){
                String FotoString = str.substring(str.indexOf("<Foto>") + 6,str.indexOf("</Foto>"));
                String Nome       = str.substring(str.indexOf("<Nome>") + 6,str.indexOf("</Nome>"));
                String Data       = str.substring(str.indexOf("<Data>") + 6,str.indexOf("</Data>"));
                String Email      = str.substring(str.indexOf("<Email>") + 7,str.indexOf("</Email>"));
                pessoaArrayList.add(new Pessoa(Integer.parseInt(FotoString),Nome,CalculaIdadeAnos(Data),Email));
            }

        }
        catch (ParseException e)
        {Toast.makeText(this, "Error : " + e, Toast.LENGTH_SHORT).show();
        e.printStackTrace(); }

        pessoaAdapter = new PessoaAdapter(this, R.layout.customer_row, pessoaArrayList);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(pessoaAdapter);
        // handle click event and set desc on textview
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pessoa pessoa = (Pessoa) adapterView.getItemAtPosition(i);
                //fruitDesc.setText(pessoa.getName());
                tv_User.setText(pessoa.getName());
                Log.e("App1"," Pessoa : "+pessoa.getName());
            }
        });
    }

    public void SetAutocomplete(AutoCompleteTextView AutoComplete){
        // Array of strings storing country names
        String[] countries = new String[] {
                "antes",
                "depois",
                "download",
                "marin_hinkle",
                "melanie_lynskey",
                "melanie_lynskey2",
                "molde_antes",
                "molde_depoiss",
        };

        // Array of integers points to images stored in /res/drawable-ldpi/
        int[] flags = new int[]{
                R.drawable.antes,
                R.drawable.depois,
                R.drawable.download,
                R.drawable.marin_hinkle,
                R.drawable.melanie_lynskey,
                R.drawable.melanie_lynskey2,
                R.drawable.molde_antes,
                R.drawable.molde_depois,
        };

        // Array of strings to store currencies
        String[] currency = new String[]{
                "Indian Rupee",
                "Pakistani Rupee",
                "Sri Lankan Rupee",
                "Renminbi",
                "Bangladeshi Taka",
                "Nepalese Rupee",
                "Afghani",
                "North Korean Won",
        };

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<8;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", countries[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            hm.put("cur", currency[i]);
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "flag","txt"};

        // Ids of views in listview_layout
        int[] to = { R.id.ivCustomerImage, R.id.tvCustomer};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.customer_row, from, to);


        /** Defining an itemclick event listener for the autocompletetextview */
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {

                /** Each item in the adapter is a HashMap object.
                 *  So this statement creates the currently clicked hashmap object
                 * */
                HashMap<String, String> hm = (HashMap<String, String>) arg0.getAdapter().getItem(position);

                /** Getting a reference to the TextView of the layout file activity_main to set Currency */
                TextView tvCurrency = (TextView) findViewById(R.id.tvCustomer) ;

                /** Getting currency from the HashMap and setting it to the textview */
                tvCurrency.setText("Currency : " + hm.get("cur"));
            }
        };

        /** Setting the itemclick event listener */
        AutoComplete.setOnItemClickListener(itemClickListener);

        /** Setting the adapter to the listView */
        AutoComplete.setAdapter(adapter);
    }

    /** A callback method, which is executed when this activity is about to be killed
     * This is used to save the current state of the activity
     * ( eg :  Configuration changes : portrait -> landscape )
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextView tvCurrency = (TextView) findViewById(R.id.tvCustomer) ;
        outState.putString("currency", tvCurrency.getText().toString());
        super.onSaveInstanceState(outState);
    }

    /** A callback method, which is executed when the activity is recreated
     * ( eg :  Configuration changes : portrait -> landscape )
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        TextView tvCurrency = (TextView) findViewById(R.id.tvCustomer) ;
        tvCurrency.setText(savedInstanceState.getString("currency"));
        super.onRestoreInstanceState(savedInstanceState);
    }
    

    public  long CalculaIdadeAnos(String data) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //DateFormat df = DateFormat.getDateInstance();
        Date date = sdf.parse(data);
        return (new Date().getTime() - date.getTime()) / (31536000000L);
    }

}