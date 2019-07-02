package heisenber737.ukpolice;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mysingleton.MySingleton;

public class GetForces {

    Context context;
    ArrayList<forces_cl> arrayList = new ArrayList<>();


    public GetForces(Context context) {
        this.context = context;

    }

    public ArrayList<forces_cl> getList() {


        return arrayList;
    }
}
