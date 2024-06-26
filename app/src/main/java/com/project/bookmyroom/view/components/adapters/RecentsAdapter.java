package com.project.bookmyroom.view.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.bookmyroom.R;
import com.project.bookmyroom.viewmodel.RecentsData;

import java.util.List;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder> {

    Context context;
    List<RecentsData> recentsDataList;

    public RecentsAdapter(Context context, List<RecentsData> recentsDataList) {
        this.context = context;
        this.recentsDataList = recentsDataList;
    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recents_hotels_row_item, parent, false);
        return new RecentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {
        RecentsData currentItem = recentsDataList.get(position);

        holder.countryName.setText(currentItem.getCountryName());
        holder.placeName.setText(currentItem.getPlaceName());
        holder.price.setText(currentItem.getPrice());

        // Load image using Glide
        Glide.with(context)
                .load(currentItem.getImageUrl()) // Assuming imageUrl is a valid URL string
               /* .placeholder(R.drawable.placeholder_image) // Placeholder image while loading
                .error(R.drawable.error_image) // Error image if loading fails*/
                .into(holder.placeImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent i=new Intent(context, DetailsActivity.class);
                context.startActivity(i);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return recentsDataList.size();
    }
    public void setData(List<RecentsData> newData) {
        recentsDataList.clear();
        recentsDataList.addAll(newData);
        notifyDataSetChanged();
    }

    public static final class RecentsViewHolder extends RecyclerView.ViewHolder {
        ImageView placeImage;
        TextView placeName, countryName, price;

        public RecentsViewHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.place_image2);
            placeName = itemView.findViewById(R.id.place_name);
            countryName = itemView.findViewById(R.id.country_name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
