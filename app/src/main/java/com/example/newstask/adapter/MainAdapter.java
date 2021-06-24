package com.example.newstask.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newstask.R;
import com.example.newstask.model.Article;
import com.example.newstask.utils.OnRecyclerViewitemClicklistener;

import java.util.List;

public class MainAdapter  extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Article> articleArrayList;
    private Context context;
    private OnRecyclerViewitemClicklistener OnRecyclerViewitemClicklistener;
    public MainAdapter(List<Article> articleArrayList) {
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row, parent, false);
        return new MainAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {

        final Article articleModel = articleArrayList.get(position);
        if(!TextUtils.isEmpty(articleModel.getTitle())) {
            holder.txt_title.setText(articleModel.getTitle());
        }
        if(!TextUtils.isEmpty(articleModel.getAuthor())) {
            holder.txt_name.setText(articleModel.getAuthor());
        }
        if(!TextUtils.isEmpty(articleModel.getPublishedAt())) {
            holder.txt_date.setText(articleModel.getPublishedAt());
        }

        holder.linearlayout.setTag(articleModel);

    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_title;
        private TextView txt_name;
        private TextView txt_date;
//        private ImageView img_pic;
        private LinearLayout linearlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_title = itemView.findViewById(R.id.txt_title);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_date = itemView.findViewById(R.id.txt_date);
//            img_pic = itemView.findViewById(R.id.img_pic);
            linearlayout = itemView.findViewById(R.id.linearlayout);

            linearlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (OnRecyclerViewitemClicklistener != null) {
                        OnRecyclerViewitemClicklistener.onItemClick(getAdapterPosition(), v);
                    }
                }
            });

        }
    }
    public void setOnRecyclerViewItemClickListener(OnRecyclerViewitemClicklistener onRecyclerViewItemClickListener) {
        this.OnRecyclerViewitemClicklistener = onRecyclerViewItemClickListener;
    }
}
