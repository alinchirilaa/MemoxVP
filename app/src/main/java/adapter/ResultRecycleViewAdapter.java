package adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.memoxvp.R;

import java.util.List;

import POJOs.Client;
import POJOs.RecyclerItem;


public class ResultRecycleViewAdapter extends RecyclerView.Adapter<ResultRecycleViewAdapter.ResultViewHolder> {

    private List<Client> recyclerItemList;
    private Context mContext;

    public ResultRecycleViewAdapter(List<Client> recyclerItemList, Context mContext) {
        this.recyclerItemList = recyclerItemList;
        this.mContext = mContext;
    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.client_row, null);

        ResultViewHolder resultViewHolder = new ResultViewHolder(view);

        return resultViewHolder;
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {


        Client recyclerItem = recyclerItemList.get(position);

        holder.imageViewDenumireAgent.setImageResource(R.drawable.info_icon);
        holder.imageViewCodFiscal.setImageResource(R.drawable.fiscal_icon);
        holder.imageViewAdresa.setImageResource(R.drawable.adress_icon);
        holder.imageViewLocalitate.setImageResource(R.drawable.city_icon);

        holder.textViewDenumireAgent.setText(recyclerItem.getDenumireAgent());
        holder.textViewCodFiscal.setText(recyclerItem.getCodFiscal());
        holder.textViewAdresa.setText(recyclerItem.getAdresa());
        holder.textViewLocalitate.setText(recyclerItem.getLocalitate());

    }

    @Override
    public int getItemCount() {
        return recyclerItemList.size();
    }


    public class ResultViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageViewDenumireAgent;
        protected ImageView imageViewCodFiscal;
        protected ImageView imageViewAdresa;
        protected ImageView imageViewLocalitate;

        protected TextView textViewDenumireAgent;
        protected TextView textViewCodFiscal;
        protected TextView textViewAdresa;
        protected TextView textViewLocalitate;

        public ResultViewHolder(View view) {
            super(view);
            this.imageViewDenumireAgent = (ImageView) view.findViewById(R.id.thumbnail);
            this.imageViewCodFiscal = (ImageView) view.findViewById(R.id.thumbnail_cod_fiscal);
            this.imageViewAdresa = (ImageView) view.findViewById(R.id.thumbnail_adresa);
            this.imageViewLocalitate = (ImageView) view.findViewById(R.id.thumbnail_localitate);

            this.textViewDenumireAgent = (TextView) view.findViewById(R.id.title);
            this.textViewCodFiscal = (TextView) view.findViewById(R.id.title_adresa);
            this.textViewAdresa = (TextView) view.findViewById(R.id.title_cod_fiscal);
            this.textViewLocalitate = (TextView) view.findViewById(R.id.title_localitate);
        }
    }


    public void clearRecycler() {
        int size = recyclerItemList.size();

        if (size > 0) {
            recyclerItemList.clear();
        }

    }

}
