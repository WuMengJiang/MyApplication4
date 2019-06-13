package com.example.dell_pc.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.dell_pc.myapplication.R;
import com.example.dell_pc.myapplication.bean.RecBean;
import com.example.dell_pc.myapplication.bean.Students;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<RecBean.ResultBean> resultBeans = new ArrayList<>();
    private Context context;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    public interface OnClickListener{
        void  onClick(int position ,View view);
    }
    public void setStudents(ArrayList<RecBean.ResultBean> resultBeans) {
        this.resultBeans = resultBeans;
        notifyDataSetChanged();
    }

    public RecAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_1, null);
            ViewHolderA viewHolderA = new ViewHolderA(inflate);
            return viewHolderA;
        }else if (i==1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_2, null);
            return new ViewHolderB(inflate);
        }else if (i==2){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_3, null);
            return new ViewHolderC(inflate);
        }else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_4, null);
            return new ViewHolderD(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int i) {
        int itemViewType = getItemViewType(i);

        if (itemViewType==0){
            ViewHolderA holderA = (ViewHolderA) holder;
            holderA.tv_head.setText(resultBeans.get(i).getText());
             RoundedCorners roundedCorners = new RoundedCorners(90);
                     RequestOptions options = RequestOptions.bitmapTransform(roundedCorners)
                             .circleCrop();
            Glide.with(context).load(resultBeans.get(i).getThumbnail()).into(holderA.iv_head);

            holderA.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(i,v);
                }
            });
        }else if (itemViewType==1){
            ViewHolderB holderB = (ViewHolderB) holder;
            holderB.tv_2_1.setText(resultBeans.get(i).getText());
            holderB.tv_2_2.setText(resultBeans.get(i).getText());
            Glide.with(context).load(resultBeans.get(i).getThumbnail()).into(holderB.iv_2_1);
            Glide.with(context).load(resultBeans.get(i).getTop_comments_header()).into(holderB.iv_2_2);
            holderB.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(i,v);
                }
            });
        }else if (itemViewType==2){
            ViewHolderC holderC = (ViewHolderC) holder;
            holderC.tv_3.setText(resultBeans.get(i).getText());
            Glide.with(context).load(resultBeans.get(i).getThumbnail()).into(holderC.iv3);
            holderC.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(i,v);
                }
            });
        }else {
            ViewHolderD holderD = (ViewHolderD) holder;
            holderD.tv_4.setText(resultBeans.get(i).getText());
            Glide.with(context).load(resultBeans.get(i).getThumbnail()).into(holderD.iv4);
            holderD.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(i,v);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }
    public class ViewHolderA extends RecyclerView.ViewHolder{
        private  TextView tv_head;
        private  ImageView iv_head;
        public ViewHolderA(@NonNull View itemView) {
            super(itemView);
            tv_head = itemView.findViewById(R.id.tv_head);
            iv_head = itemView.findViewById(R.id.iv_head);
        }
    }
    public class ViewHolderB extends RecyclerView.ViewHolder{

        private  TextView tv_2_1;
        private  TextView tv_2_2;
        private  ImageView iv_2_1;
        private  ImageView iv_2_2;

        public ViewHolderB(@NonNull View itemView) {
            super(itemView);
            tv_2_1 = itemView.findViewById(R.id.tv_2_1);
            tv_2_2 = itemView.findViewById(R.id.tv_2_2);
            iv_2_1 = itemView.findViewById(R.id.iv_2_1);
            iv_2_2 = itemView.findViewById(R.id.iv_2_2);
        }
    }
    public class ViewHolderC extends RecyclerView.ViewHolder{

        private  TextView tv_3;
        private  ImageView iv3;

        public ViewHolderC(@NonNull View itemView) {
            super(itemView);
            tv_3 = itemView.findViewById(R.id.tv_3_1);
            iv3 = itemView.findViewById(R.id.iv_3_1);
        }
    }
    public class ViewHolderD extends RecyclerView.ViewHolder{
        private  TextView tv_4;
        private  ImageView iv4;
        public ViewHolderD(@NonNull View itemView) {
            super(itemView);
            tv_4 = itemView.findViewById(R.id.tv_4_1);
            iv4 = itemView.findViewById(R.id.iv_4_1);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position%4==0){
            return 0;
        }else if (position%4==0){
            return 1;
        }else if (position%4==0){
            return 2;
        }else {
            return 3;
        }
    }
}
