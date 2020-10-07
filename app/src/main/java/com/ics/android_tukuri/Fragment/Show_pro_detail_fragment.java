package com.ics.android_tukuri.Fragment;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.github.chrisbanes.photoview.PhotoView;
import com.ics.android_tukuri.Config.BaseURL;
import com.ics.android_tukuri.R;
import com.ics.android_tukuri.DatabaseHandler;
import com.ics.android_tukuri.MainActivity;

import java.util.HashMap;

public class Show_pro_detail_fragment extends Fragment {

    TextView add_to_cart,prod_buy_now,prod_name,tv_prod_price,tv_prod_desc,prod_in_stock, dtx1, dtx2, d1, d2, dd1 ,dd2;;
    ImageView prod_img,iv_special_offer;
    CheckBox ch1, ch2;
    private SliderLayout imgSlider;

    private DatabaseHandler dbcart;
    private Context context;
    HashMap<String, String> map = new HashMap<>();


    public Show_pro_detail_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_show_prod_detail, container, false);

        ((com.ics.android_tukuri.MainActivity) getActivity()).setTitle("Product Detail");
        ((com.ics.android_tukuri.MainActivity)getActivity()).BackIC();

        add_to_cart=view.findViewById(R.id.add_to_cart);
        imgSlider = view.findViewById(R.id.imageslider);
        prod_img=view.findViewById(R.id.prod_img);
        prod_name=view.findViewById(R.id.prod_name);
        tv_prod_price=view.findViewById(R.id.tv_prod_price);
        tv_prod_desc=view.findViewById(R.id.tv_prod_desc);
        iv_special_offer=view.findViewById(R.id.iv_special_offer);
        prod_in_stock=view.findViewById(R.id.prod_in_stock);
        prod_buy_now=view.findViewById(R.id.prod_buy_now);
        dtx1 = (TextView) view.findViewById(R.id.tx_dis1);
        dtx2 = (TextView) view.findViewById(R.id.tx_dis2);
        ch1 = (CheckBox) view.findViewById(R.id.chk1);
        ch2 = (CheckBox) view.findViewById(R.id.chk2);
        d1 = (TextView) view.findViewById(R.id.tx_d1);
        dd1 = (TextView) view.findViewById(R.id.tx_dd1);
        d2 = (TextView) view.findViewById(R.id.tx_d2);
        dd2 = (TextView) view.findViewById(R.id.tx_dd2);

        dbcart = new DatabaseHandler(getActivity());

        // initialize a SliderLayout
        imgSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        imgSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        imgSlider.setCustomAnimation(new DescriptionAnimation());
        imgSlider.setDuration(4000);

        try {
            map.put("product_id", getArguments().getString("product_id"));
            map.put("category_id", getArguments().getString("category_id"));
            map.put("product_image", getArguments().getString("product_image"));
            map.put("product_image2", getArguments().getString("product_image2"));
            map.put("product_image3", getArguments().getString("product_image3"));
            map.put("product_image4", getArguments().getString("product_image4"));
            map.put("increament", getArguments().getString("increament"));
            map.put("product_name", getArguments().getString("product_name"));
            map.put("price",getArguments().getString("price"));
            map.put("stock",getArguments().getString("stock"));
            map.put("title", getArguments().getString("title"));
            map.put("unit", getArguments().getString("unit"));
            map.put("Mrp", getArguments().getString("Mrp"));
            map.put("unit_value", getArguments().getString("unit_value"));
            map.put("Prod_description", getArguments().getString("Prod_description"));
            map.put("pack1",getArguments().getString("pack1"));
            map.put("pack2",getArguments().getString("pack2"));
            map.put("mrp1",getArguments().getString("mrp1"));
            map.put("mrp2",getArguments().getString("mrp2"));
            map.put("price1",getArguments().getString("price1"));
            map.put("price2",getArguments().getString("price2"));
        }catch (Exception e){

        }


        DefaultSliderView defaultSliderView = new DefaultSliderView(getActivity());
        if (!map.get("product_image").matches("")){
            defaultSliderView.image(BaseURL.IMG_PRODUCT_URL+map.get("product_image")).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    show_zoom_img(BaseURL.IMG_PRODUCT_URL+map.get("product_image"));
                }
            });
            imgSlider.addSlider(defaultSliderView);
        }
        if (!map.get("product_image2").matches("")){
            defaultSliderView = new DefaultSliderView(getActivity());
            defaultSliderView.image(BaseURL.IMG_PRODUCT_URL+map.get("product_image2")).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    show_zoom_img(BaseURL.IMG_PRODUCT_URL+map.get("product_image2"));
                }
            });
            imgSlider.addSlider(defaultSliderView);
        }
        if (!map.get("product_image3").matches("")){
            defaultSliderView = new DefaultSliderView(getActivity());
            defaultSliderView.image(BaseURL.IMG_PRODUCT_URL+map.get("product_image3")).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    show_zoom_img(BaseURL.IMG_PRODUCT_URL+map.get("product_image3"));
                }
            });
            imgSlider.addSlider(defaultSliderView);
        }
        if (!map.get("product_image4").matches("")){
            defaultSliderView = new DefaultSliderView(getActivity());
            defaultSliderView.image(BaseURL.IMG_PRODUCT_URL+map.get("product_image4")).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    show_zoom_img(BaseURL.IMG_PRODUCT_URL+map.get("product_image4"));
                }
            });
            imgSlider.addSlider(defaultSliderView);
        }


        prod_name.setText(map.get("product_name"));
        tv_prod_desc.setText("Product Description: "+map.get("Prod_description"));
        tv_prod_price.setText(map.get("unit_value")+" "+map.get("unit")+" "+"INR "+map.get("price"));

        if (!map.get("pack1").matches("")) {
            d1.setText(""+map.get("pack1")+" - ");}

        if (!map.get("pack2").matches("")){
            d2.setText(""+map.get("pack2")+" - "); }

        dd1.setText("Rs. "+map.get("mrp1"));
        dd2.setText("Rs. "+map.get("mrp2"));

        dtx1.setText("Rs. "+map.get("price1"));
        dtx2.setText("Rs. "+map.get("price2"));


        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ch1.isChecked())
                {
                    ch2.setChecked(false);
                }
                else
                {
                }
            }
        });

        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ch2.isChecked())
                {
                    ch1.setChecked(false);
                }
                else
                {
                }
            }
        });

        if(Integer.parseInt(getArguments().getString("stock")) >0){
            prod_in_stock.setText("In Stock");
        }else {
            prod_in_stock.setText("Out of Stock");
            prod_in_stock.setTextColor(Color.RED);
        }

        //*****************************************
        Glide.with(getActivity())
                .load(BaseURL.IMG_PRODUCT_URL + map.get("product_image"))
//                .centerCrop()
                .placeholder(R.drawable.app_icon)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(prod_img);


        Glide.with(getActivity())
                .load(R.drawable.app_icon)
//                .centerCrop()
                .placeholder(R.drawable.app_icon)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(iv_special_offer);

        if (dbcart.isInCart(map.get("product_id"))) {
            add_to_cart.setText(getResources().getString(R.string.tv_btn_gocart));

        } else {
            add_to_cart.setText(getResources().getString(R.string.tv_btn_addcart));
        }


        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Integer.parseInt(getArguments().getString("stock")) >0){

                    if (add_to_cart.getText().toString().equals(getResources().getString(R.string.tv_btn_addcart))){

                        Toast.makeText(getActivity(), "Add to cart Successfully", Toast.LENGTH_SHORT).show();

                        if (dbcart.isInCart(map.get("product_id"))) {

                            if (ch1.isChecked())
                            {
                                map.put("offer","1");
                                Log.e("OFFER 1","11111");
                            }
                            else if (ch2.isChecked())
                            {
                                map.put("offer","2");
                                Log.e("OFFER 2","22222");
                            }
                            else
                            {
                                map.put("offer","0");
                                Log.e("OFFER 0","0000000000");
                            }
                            dbcart.setCart(map, Float.valueOf("1"));
                            add_to_cart.setText(getResources().getString(R.string.tv_btn_gocart));

                        } else {

                            if (ch1.isChecked())
                            {
                                map.put("offer","1");
                                Log.e("OFFER 1","11111");
                            }
                            else if (ch2.isChecked())
                            {
                                map.put("offer","2");
                                Log.e("OFFER 2","22222");
                            }
                            else
                            {
                                map.put("offer","0");
                                Log.e("OFFER 0","0000000000");
                            }

                            dbcart.setCart(map, Float.valueOf("1"));
                            add_to_cart.setText(getResources().getString(R.string.tv_btn_gocart));
                        }
                        ((com.ics.android_tukuri.MainActivity)getActivity()).setCartCounter(""+ dbcart.getCartCount());

                    }
                    else
                    {
                        Fragment Favorite_List=new Cart_fragment();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.contentPanel,Favorite_List);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }

                }else {

                    if (add_to_cart.getText().toString().equals(getResources().getString(R.string.tv_btn_addcart))){

                        Toast.makeText(getActivity(), "Sorry, Out of Stock", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Fragment Favorite_List=new Cart_fragment();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.contentPanel,Favorite_List);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                }

            }
        });
        //**********************************
        prod_buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Integer.parseInt(getArguments().getString("stock")) >0){

                    if (dbcart.isInCart(map.get("product_id"))) {

                        if (ch1.isChecked())
                        {
                            map.put("offer","1");
                            Log.e("OFFER 1","11111");
                        }
                        else if (ch2.isChecked())
                        {
                            map.put("offer","2");
                            Log.e("OFFER 2","22222");
                        }
                        else
                        {
                            map.put("offer","0");
                            Log.e("OFFER 0","0000000000");
                        }
                        dbcart.setCart(map, Float.valueOf("1"));

                    } else {
                        if (ch1.isChecked())
                        {
                            map.put("offer","1");
                            Log.e("OFFER 1","11111");
                        }
                        else if (ch2.isChecked())
                        {
                            map.put("offer","2");
                            Log.e("OFFER 2","22222");
                        }
                        else
                        {
                            map.put("offer","0");
                            Log.e("OFFER 0","0000000000");
                        }
                        dbcart.setCart(map, Float.valueOf("1"));
                    }
                    ((MainActivity)getActivity()).setCartCounter(""+ dbcart.getCartCount());

                    Fragment Favorite_List=new Cart_fragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.contentPanel,Favorite_List);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }else {
                    Toast.makeText(getActivity(), "Sorry, Out of Stock", Toast.LENGTH_SHORT).show();
                }
            }
        });

        prod_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showImage(map.get("product_image"));

            }
        });

        return view;
    }

    private void showImage(String product_image) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.product_image_dialog);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.show();

        ImageView iv_image_cancle = (ImageView) dialog.findViewById(R.id.iv_dialog_cancle);
        ImageView iv_image = (ImageView) dialog.findViewById(R.id.iv_dialog_img);

        Glide.with(getActivity())
                .load(BaseURL.IMG_PRODUCT_URL + product_image)
                .placeholder(R.drawable.app_icon)
                .crossFade()
                .into(iv_image);

        iv_image_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }


    private void show_zoom_img(String imageurl){

        final Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_slider_zoomimage);
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        final ImageView cancel = dialog.findViewById(R.id.ic_close);
        final PhotoView photoView = dialog.findViewById(R.id.photo_view);

        Glide.with(getActivity())
                .load(imageurl)
                .placeholder(getActivity().getResources().getDrawable(R.drawable.app_icon))
                .into(photoView);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();          }});

        dialog.show();
        dialog.setCanceledOnTouchOutside(true);
    }

}
