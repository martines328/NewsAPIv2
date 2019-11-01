package com.example.newsapiv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapiv2.API.Arcticle;
import com.example.newsapiv2.Room.EntityDB;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    List<Arcticle> arcticles;
    Context context  ;


    public Adapter(List<Arcticle> arcticles, Context context) {

        this.arcticles = arcticles;
       this.context = context;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       /* LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
      View view = LayoutInflater.from(context).inflate(R.layout.arcticle_recycler_item,parent,false);
      return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        Arcticle model = arcticles.get(position);



        String urlToImage = model.getUrlToImage();
        final String urlView = model.getUrl();



        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        holder.author.setText(model.getAuthor());
        holder.name.setText(model.getSource().getName());


        Glide.with(context).load(urlToImage).into(holder.imageView);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, WebViewNew.class);
                intent.putExtra("url", urlView);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return arcticles.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title, description, author, name;
        WebView webView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.imageView_arcticle);
            title = itemView.findViewById(R.id.title_TV);
            description = itemView.findViewById(R.id.description_TV);
            author = itemView.findViewById(R.id.author_TV);
            name = itemView.findViewById(R.id.ArcticleName_TV);

            webView = itemView.findViewById(R.id.webView);


        }


    }
}
