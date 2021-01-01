package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new MainRecyclerViewAdapter());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    private static class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewViewHolder>{
        @Override
        public MainRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
            return new MainRecyclerViewViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MainRecyclerViewViewHolder holder, int position){
            holder.setTitle((position+1)+"번째 아이템입니다.");
        }

        @Override
        public int getItemCount(){
            return 10;
        }
    }

    private static class MainRecyclerViewViewHolder extends RecyclerView.ViewHolder{
        private final TextView title;

        public MainRecyclerViewViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }

        public void setTitle(String title){
            this.title.setText(title);
        }
    }
}