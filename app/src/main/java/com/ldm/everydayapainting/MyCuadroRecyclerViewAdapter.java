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

        holder.textViewName.setText(holder.mItem.getName());
        holder.textViewAuthor.setText(holder.mItem.getAuthor());
        holder.textViewYear.setText(String.valueOf(holder.mItem.getYear()));
        holder.textViewTechnique.setText(holder.mItem.getTechnique());
        holder.textViewStyle.setText(holder.mItem.getStyle());
        holder.textViewLocation.setText(holder.mItem.getLocation());

        Glide.with(ctx)
              .load(holder.mItem.getUrl())
              .centerCrop()
              .into(holder.imageViewPhoto);

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
        public final TextView textViewName;
        public final ImageView imageViewPhoto;
        public final TextView textViewAuthor;
        public final TextView textViewYear;
        public final TextView textViewTechnique;
        public final TextView textViewStyle;
        public final TextView textViewLocation;
        public Cuadro mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewName = view.findViewById(R.id.textViewName);
            imageViewPhoto = view.findViewById(R.id.imageViewPhoto);
            textViewAuthor = view.findViewById(R.id.textViewAuthor);
            textViewYear = view.findViewById(R.id.textViewYear);
            textViewTechnique = view.findViewById(R.id.textViewTechnique);
            textViewStyle = view.findViewById(R.id.textViewStyle);
            textViewLocation = view.findViewById(R.id.textViewLocation);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewName.getText() + " - " + textViewAuthor.getText() +  "'";
        }
    }
}