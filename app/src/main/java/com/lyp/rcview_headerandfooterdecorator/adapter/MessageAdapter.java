package com.lyp.rcview_headerandfooterdecorator.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.lyp.rcview_headerandfooterdecorator.R;
import com.lyp.rcview_headerandfooterdecorator.bean.Message;

import java.util.List;

/**
 * Created by lyp on 2016/9/23.
 */
public class MessageAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Message> mData;

    public interface OnItemClickListener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public MessageAdapter(Context context, List<Message> data) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolder.createViewHolder(mContext, parent, R.layout.item_message);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Message bean = mData.get(position);

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickListener != null)
        {
            holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(holder.getConvertView(), position); //如果用holder.getAdapterPosition()则在装饰后计算含有头部时的位置
                }
            });

            holder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemClickListener.onItemLongClick(holder.getConvertView(), holder.getAdapterPosition());
                    return false;
                }
            });
        }

        holder.setText(R.id.itemMsgName, bean.getName());
        holder.setText(R.id.itemMsgContent, bean.getContent());
        holder.setText(R.id.itemMsgTime, bean.getTime());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
