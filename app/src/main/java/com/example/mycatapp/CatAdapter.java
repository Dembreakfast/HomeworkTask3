package com.example.mycatapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private List<Cat> catsToAdapt;
    private Context context;

    public void CatAdapter(List<Cat> catsToAdapt, Context context) {
        this.catsToAdapt = catsToAdapt;
        this.context = context;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat, parent, false);

        CatViewHolder catViewHolder = new CatViewHolder(view);
        return catViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        final Cat catAtPosition = catsToAdapt.get(position);

        // Contrast how I wrote this method with the method for ArticleAdapter. They both achieve
        // the same goal, but this way is cleaner. I defined my own method "bind" in the CatViewHolder
        // class, and all the assignment and setup is done in there instead.
        holder.bind(catAtPosition);
    }

    @Override
    public int getItemCount() {
        return catsToAdapt.size();
    }

    public static class CatViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView nameTextView;
        public TextView temperamentTextView;
        public ImageView catImageView;


        // This constructor is used in onCreateViewHolder
        public CatViewHolder(View v) {
            super(v);  // runs the constructor for the ViewHolder superclass
            view = v;
            nameTextView = v.findViewById(R.id.cat_name);
            temperamentTextView = v.findViewById(R.id.cat_temperament);
            catImageView = v.findViewById(R.id.cat_thumbnail);

        }

        // See comment in onBindViewHolder
        public void bind(final Cat cat) {
            nameTextView.setText(cat.getName());
            temperamentTextView.setText(cat.getTemperament());


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();

                    Intent intent = new Intent(context, CatDetailActivity.class);

                    intent.putExtra("name", cat.getName());
                    intent.putExtra("id", cat.getId());
                    context.startActivity(intent);
                }
            });

//            shareImageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Context context = view.getContext();
//                    Intent intent = new Intent(Intent.ACTION_SEND);
//
//                    intent.putExtra(Intent.EXTRA_TEXT, cat.getName());
//                    intent.setType("text/plain");
//                    context.startActivity(intent);
//                }
//            });

            //    String imageUrl = cat.get();
            //  Glide.with(view.getContext()).load(imageUrl).into(catImageView);
        }
    }
}
