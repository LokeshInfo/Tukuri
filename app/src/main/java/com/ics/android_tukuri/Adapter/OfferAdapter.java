package com.ics.android_tukuri.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import com.ics.android_tukuri.Config.BaseURL;
import com.ics.android_tukuri.Model.OfferModel;
import com.ics.android_tukuri.R;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder>  {
    private static final String TAG = "OfferAdapter";
    private ArrayList<OfferModel> OffList;
    public Context context;
    String resId = "";
    String finalStatus = "";
    String Image;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView idProductName, idProductPrice, p_mrp, p_save;
        RelativeLayout card;
        ImageView idProductImage;
        int pos;

        public ViewHolder(View view) {
            super(view);

            idProductName = (TextView) view.findViewById(R.id.idProductName);
            idProductPrice = (TextView) view.findViewById(R.id.idProductPrice);
            idProductImage = (ImageView) view.findViewById(R.id.idProductImage);
            p_mrp = (TextView) view.findViewById(R.id.idProductMrp);
            p_save = (TextView) view.findViewById(R.id.idProductsave);
            card = (RelativeLayout) view.findViewById(R.id.card_view);

        }
    }

    public static Context mContext;

    public OfferAdapter(Context mContext, ArrayList<OfferModel> offer_list) {
        context = mContext;
        OffList = offer_list;

    }

    @Override
    public OfferAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_menu, parent, false);

        return new OfferAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final OfferAdapter.ViewHolder viewHolder, final int position) {
        OfferModel offerModel = OffList.get(position);
        viewHolder.idProductName.setText(offerModel.getOffersCatDesc());
        Image = offerModel.getProductImage();
        Glide.with(context)
                .load(BaseURL.IMG_PRODUCT_URL + Image)
                .placeholder(R.mipmap.app_ilogo)
                .into(viewHolder.idProductImage);

        viewHolder.idProductName.setText(offerModel.getProductName());
        viewHolder.idProductPrice.setText(context.getResources().getString(R.string.currency)+"" + offerModel.getPrice());

        viewHolder.p_mrp.setText("Mrp "+offerModel.getMrp());
        viewHolder.p_save.setText("Save ₹ "+(Integer.parseInt(offerModel.getMrp()) - Integer.parseInt(offerModel.getPrice())));

    }

    @Override
    public int getItemCount() {
        return OffList.size();
    }

}
