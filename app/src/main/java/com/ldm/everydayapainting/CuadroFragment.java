package com.ldm.everydayapainting;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ldm.everydayapainting.database.db.MyRoom;
import com.ldm.everydayapainting.database.entity.Cuadro;

import java.util.ArrayList;
import java.util.List;

/*
 * A fragment representing a list of Items.
 */
public class CuadroFragment extends Fragment {

    RecyclerView recyclerView;
    MyCuadroRecyclerViewAdapter adapterCuadros;
    List<Cuadro> cuadroList;
    String query;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CuadroFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CuadroFragment newInstance(int columnCount) {
        CuadroFragment fragment = new CuadroFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuadro_list, container, false);

        query = ((CuadroActivity) getActivity()).getQuery();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            // Rellenar la lista de elementos (Cuadros)
            // Dependiendo del query, la consulta cambiará
            switch (query) {
                case "all": cuadroList =  MyRoom.getMyRoom(getContext()).cuadroDAO().findAllCuadro();
                           break;
                default: cuadroList = new ArrayList<>();
                         Toast.makeText(context, "No hay cuadros que mostrar", Toast.LENGTH_LONG).show();
                         break;
            }

            //Asociamos el Adaptador al RecyclerView
            adapterCuadros = new MyCuadroRecyclerViewAdapter(getActivity(), cuadroList, mListener);
            recyclerView.setAdapter(adapterCuadros);
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException("Must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        public void onListFragmentInteraction(Cuadro item);
    }
}