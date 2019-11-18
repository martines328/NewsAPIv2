package com.example.newsapiv2.Room;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapiv2.R;
import com.example.newsapiv2.WebViewNew;

import java.util.ArrayList;
import java.util.List;


public class Adapter1 extends RecyclerView.Adapter<Adapter1.MyViewHolder> {
    static Context context  ;
    List<EntityDB> listEntity = new ArrayList<>();


    public Adapter1( Context context, List<EntityDB> listEntity) {

       // this.arcticles = arcticles;
       this.context = context;
       this.listEntity = listEntity;


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View view = LayoutInflater.from(context).inflate(R.layout.arcticle_recycler_item,parent,false);
      return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {




        EntityDB entityDB = listEntity.get(position);

        String urlToImage = entityDB.getUrlToImage();
        final String urlView = entityDB.getUrlView();


        holder.title.setText(entityDB.getTitle());
        holder.description.setText((entityDB.getDescription()));
        holder.author.setText(entityDB.getAuthor());
        holder.name.setText(entityDB.getName());

        Glide.with(context).load(urlToImage).into(holder.imageView);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, WebViewNew.class);
                intent.putExtra("url" , urlView);
                context.startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {
        return listEntity.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title, description, author, name;
        WebView webView;
        View mView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.imageView_arcticle);
            title = itemView.findViewById(R.id.title_TV);
            description = itemView.findViewById(R.id.description_TV);
            author = itemView.findViewById(R.id.author_TV);
            name = itemView.findViewById(R.id.ArcticleName_TV);

            webView = itemView.findViewById(R.id.webView);
             mView = itemView;


        }



    }
}
