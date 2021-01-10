package com.ldm.everydayapainting;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ldm.everydayapainting.database.entity.Cuadro;

import java.util.List;

public class MyCuadroRecyclerViewAdapter extends RecyclerView.Adapter<MyCuadroRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Cuadro> mValues;
    private final CuadroFragment.OnListFragmentInteractionListener mListener;

    public MyCuadroRecyclerViewAdapter(Context context, List<Cuadro> items, CuadroFragment.OnListFragmentInteractionListener listener) {
        ctx = context;
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_cuadro, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //Recupera la información del elemento que ocupa la posición "position"
        holder.mItem = mValues.get(position);

        holder.textViewNombreRestaurante.setText(holder.mItem.getName());
        holder.textViewDireccionRestaurante.setText(holder.mItem.getLocation());
        holder.ratingBarValoracionRestaurante.setRating(holder.mItem.getYear());

        Glide.with(ctx)
              .load(holder.mItem.getUrl())
              .centerCrop()
              .into(holder.imageViewPhotoRestaurante);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, holder.mItem.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombreRestaurante;
        public final TextView textViewDireccionRestaurante;
        public final ImageView imageViewPhotoRestaurante;
        public final RatingBar ratingBarValoracionRestaurante;
        public Cuadro mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewNombreRestaurante = view.findViewById(R.id.textViewNombre);
            textViewDireccionRestaurante = view.findViewById(R.id.textViewDireccion);
            imageViewPhotoRestaurante = view.findViewById(R.id.imageViewPhoto);
            ratingBarValoracionRestaurante = view.findViewById(R.id.ratingBarValoracion);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombreRestaurante.getText() + "'";
        }
    }
}