package vamsi.com.restapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public ListAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent,false);
        return new ViewHolder(v);
        //return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem=listItems.get(position);
        holder.tvfname.setText(listItem.getFirstname());
        holder.tvlname.setText(listItem.getLastname());
        Picasso.with(context).load(listItem.getImgURL()).into(holder.imgavatar);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvfname;
        public  TextView tvlname;
        public ImageView imgavatar;
        public ViewHolder(View itemView) {
            super(itemView);
            tvfname=(TextView)itemView.findViewById(R.id.fname);
            tvlname=(TextView)itemView.findViewById(R.id.lname);
            imgavatar=(ImageView)itemView.findViewById(R.id.avatar);
        }
    }
}
