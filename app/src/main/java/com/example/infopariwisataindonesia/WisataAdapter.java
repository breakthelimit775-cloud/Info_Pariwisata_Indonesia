package com.example.infopariwisataindonesia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.WisataViewHolder> {

    private Context context;
    private List<TempatWisata> daftarWisata;
    private OnWisataListener listener;

    public WisataAdapter(Context context, List<TempatWisata> daftarWisata, OnWisataListener listener) {
        this.context = context;
        this.daftarWisata = daftarWisata;
        this.listener = listener;
    }

    @NonNull
    @Override
    public WisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card_wisata, parent, false);
        return new WisataViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull WisataViewHolder holder, int position) {
        TempatWisata wisata = daftarWisata.get(position);

        holder.tvNama.setText(wisata.getNama());
        holder.tvDeskripsi.setText(wisata.getDeskripsiSingkat());
        holder.tvRating.setText(String.format(Locale.getDefault(), "%.1f", wisata.getRating()));

        Glide.with(context)
                .load(wisata.getImageUrl())
                .into(holder.imgWisata);
    }

    @Override
    public int getItemCount() {
        return daftarWisata.size();
    }

    public void filterList(List<TempatWisata> filteredList) {
        daftarWisata = filteredList;
        notifyDataSetChanged();
    }

    public TempatWisata getItemAt(int position) {
        return daftarWisata.get(position);
    }

    public static class WisataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgWisata;
        TextView tvNama, tvDeskripsi, tvRating;
        OnWisataListener listener;

        public WisataViewHolder(@NonNull View itemView, OnWisataListener listener) {
            super(itemView);
            imgWisata = itemView.findViewById(R.id.img_card_wisata);
            tvNama = itemView.findViewById(R.id.tv_card_nama);
            tvDeskripsi = itemView.findViewById(R.id.tv_card_deskripsi);
            tvRating = itemView.findViewById(R.id.tv_card_rating);
            this.listener = listener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onWisataClick(position);
                }
            }
        }
    }

    public interface OnWisataListener {
        void onWisataClick(int position);
    }
}