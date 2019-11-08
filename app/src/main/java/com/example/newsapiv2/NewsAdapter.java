package com.example.newsapiv2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapiv2.API.Arcticle;
import com.example.newsapiv2.Room.EntityDB;
import com.example.newsapiv2.Room.NewsDataBAse;
import com.example.newsapiv2.Room.NewsRepository;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    static Context context  ;
    private List<EntityDB> list;
    NewsRepository newsRepository = new NewsRepository(context);



    public NewsAdapter(Context context ) {
        this.context = context;
       // this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.arcticle_recycler_item,parent,false);
        return new NewsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


        list = newsRepository.getAllNews();
        EntityDB entityDB = list.get(position);

        holder.title.setText(entityDB.getTitle());
        holder.author.setText("author");






    }

    @Override
    public int getItemCount() {
        return 0;
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
