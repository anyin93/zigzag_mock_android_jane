package com.example.zigzag.src.product.buy;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zigzag.R;
import com.example.zigzag.src.product.ProductActivity;
import com.example.zigzag.src.product.buy.interfaces.BuyActivityView;
import com.example.zigzag.src.product.buy.models.BasketResponse;
import com.example.zigzag.src.product.models.ItemResponse;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import static com.example.zigzag.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.zigzag.src.ApplicationClass.sSharedPreferences;

public class BuyDialog extends BottomSheetDialogFragment implements BuyActivityView {

    private TextView mTvPrice, mTvDiscount;
    private ItemResponse.ItemResult mProductVO;
    private ImageButton mBtnBascket;
    private BuyService buyService;
    private ProductActivity context;
    private View v;

    public static BuyDialog getInstance() {
        BuyDialog bottomSheetDialog = new BuyDialog();
        return bottomSheetDialog;
    }


    public void setmProductVO(ItemResponse.ItemResult productVO){
        mProductVO=productVO;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_buy_dialog, container,false);

        System.out.println("구매 다이얼로그 생성");

        initView(view);

        setDialog();

        mBtnBascket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int item_id=mProductVO.getItem_id();
                String color="green";
                String size="L";
                int num=1;
                buyService.postBasket(item_id,color,size,num);
            }
        });
        return view;
    }

    void initView(View view){
        v=view;
        buyService=new BuyService(this);
        mTvPrice=view.findViewById(R.id.buy_tv_price);
        mTvDiscount=view.findViewById(R.id.buy_tv_discount);
        mBtnBascket=view.findViewById(R.id.buy_ib_bascket);

    }

    void setDialog(){
        mTvPrice.setText(mProductVO.getPrice()+"원");
        mTvDiscount.setText(mProductVO.getDiscount());
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void basketSuccess(boolean isSuccess, int code,String message) {
        if (isSuccess) {
            //Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
            SharedPreferences.Editor editor = sSharedPreferences.edit();
            editor.putString("isBasket","Y");
            System.out.println("장바구니 널 아님");
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast_basket, (ViewGroup)v.findViewById(R.id.toast_layout));
            Toast toast = new Toast(getContext());
            toast.setGravity(Gravity.RIGHT|Gravity.TOP, 0, 0);
            toast.setView(layout);
            toast.show();


            dismiss();

        }
    }






}
