package com.example.metro_photoview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;


import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;

    private Button btn_end;
    private EndDialog mEndDialog;
    public int depart=0,dest=0,station = 0;
    int departCount=0;
    int REQUEST_CODE_POPUP_END = 10;
    int REQUEST_CODE_POPUP_DJK = 10;
    int resultcode;
    int reset_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.metromain);
        PhotoViewAttacher mAttacher = new PhotoViewAttacher(photoView);

        mAttacher.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mAttacher.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(ImageView view, float x, float y) {
                //String msg = "터치 영역 : " +x+" / " +y;
                //Toast. makeText(MainActivity. this, msg, Toast.LENGTH_SHORT ).show();
                Station_Click(x,y);
            }
        });

    }

    public void onClick(View v) {

    }

    public void Station_Click(float x, float y){

        int s_num = 0;
        int station_check=0;
        s_num = Check_station(x,y);

        if( (101<=s_num && s_num<=123) | (201<=s_num && s_num<=217) | (301<=s_num && s_num<=308) | (401<=s_num && s_num<=417) |
        (501<=s_num && s_num<=507) | (601<=s_num && s_num<=622) | (701<=s_num && s_num<=707) | (801<=s_num && s_num<=806)
        | (901<=s_num && s_num<=904) ){

            station_check=1;

            Intent intent = new Intent(this,EndDialog.class);
            intent.putExtra("station check",station_check);
            intent.putExtra("station",s_num);

            intent.putExtra("depart_station",depart);
            intent.putExtra("dest_station",dest);
            startActivityForResult(intent,REQUEST_CODE_POPUP_END);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent  data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_POPUP_END) {
            if(resultCode == 1) {
                this.resultcode = resultcode;
                depart = data.getExtras().getInt("depart_station");
                reset_code = data.getExtras().getInt("reset_code");
                if(reset_code == 1){
                    depart =0;
                    dest=0;
                    reset_code=0;
                }
            }
            else if(resultCode == 2) {
                this.resultcode = resultcode;
                dest = data.getExtras().getInt("dest_station");
                reset_code = data.getExtras().getInt("reset_code");
                if(reset_code == 1){
                    depart =0;
                    dest=0;
                    reset_code=0;
                }
            }
        }
    }


    public int Check_station(float x, float y){ // 역 체크해주는 함수


        if( 0.07283145<x && x< 0.08737977 && 0.52039397<y && y<0.5381478){return 101;} //101
        else if( 0.07283145<x && x< 0.08737977 && 0.5901217<y && y<0.6099802){return 102;} //102
        else if( 0.07283145<x && x< 0.08737977 && 0.65645707<y && y<0.67645707){return 103;} //103
        else if( 0.07283145<x && x< 0.08737977 && 0.73168176<y && y<0.75168176){return 104;} //104
        else if( 0.072<x && x< 0.092 && 0.816<y && y<0.836){return 105;} //105
        else if( 0.11850992<x && x< 0.13850992 && 0.876996<y && y<0.896996){return 106;} //106
        else if( 0.16642024<x && x< 0.18642024 && 0.876996<y && y<0.896996){return 107;} //107
        else if( 0.21673355<x && x< 0.236 && 0.876996<y && y<0.896996){return 108;} //108
        else if( 0.26101977<x && x< 0.28101977 && 0.876996<y && y<0.896996){return 109;} //109
        else if( 0.32089525<x && x< 0.34089525 && 0.876996<y && y<0.896996){return 110;} //110
        else if( 0.3670387<x && x< 0.3870387 && 0.876996<y && y<0.896996){return 111;} //111
        else if( 0.4207376<x && x< 0.4407376 && 0.876996<y && y<0.896996){return 112;} //112
        else if( 0.47442818<x && x< 0.49442818 && 0.876996<y && y<0.896996){return 113;} //113
        else if( 0.52161237<x && x< 0.54161237 && 0.80173993<y && y<0.82173993){return 114;} //114
        else if( 0.53079206<x && x< 0.55079206 && 0.732826<y && y<0.752826){return 115;} //115
        else if( 0.528<x && x< 0.548 && 0.618<y && y<0.638){return 116;} //116
        else if( 0.52863544<x && x< 0.54863544 && 0.55575824<y && y<0.57575824){return 117;} //117
        else if( 0.5150551<x && x< 0.5350551 && 0.46112075<y && y<0.48112075){return 118;} //118
        else if( 0.4199929<x && x< 0.4399929 && 0.4340567<y && y<0.4540567){return 119;} //119
        else if( 0.37524396<x && x< 0.39524396 && 0.4340567<y && y<0.4540567){return 120;} //120
        else if( 0.32522358<x && x< 0.34522358 && 0.43323958<y && y<0.45323958){return 121;} //121
        else if( 0.263<x && x< 0.283 && 0.434<y && y<0.454){return 122;} //122
        else if( 0.166<x && x< 0.186 && 0.432<y && y<0.452){return 123;} //123
        else if( 0.072<x && x< 0.092 && 0.399<y && y<0.419){return 201;} //201
        else if( 0.072<x && x< 0.092 && 0.291<y && y<0.311){return 202;} //202
        else if( 0.072<x && x< 0.092 && 0.215<y && y<0.235){return 203;} //203
        else if( 0.072<x && x< 0.092 && 0.144<y && y<0.164){return 204;} //204
        else if( 0.072<x && x< 0.092 && 0.065<y && y<0.085){return 205;} //205
        else if( 0.117<x && x< 0.137 && 0.065<y && y<0.085){return 206;} //206
        else if( 0.166<x && x< 0.186 && 0.065<y && y<0.085){return 207;} //207
        else if( 0.213<x && x< 0.233 && 0.065<y && y<0.085){return 208;} //208
        else if( 0.262<x && x< 0.282 && 0.065<y && y<0.085){return 209;} //209
        else if( 0.344<x && x< 0.364 && 0.065<y && y<0.085){return 210;} //210
        else if( 0.420<x && x< 0.440 && 0.065<y && y<0.085){return 211;} //211
        else if( 0.493<x && x< 0.513 && 0.065<y && y<0.085){return 212;} //212
        else if( 0.572<x && x< 0.592 && 0.065<y && y<0.085){return 213;} //213
        else if( 0.642<x && x< 0.662 && 0.065<y && y<0.085){return 214;} //214
        else if( 0.698<x && x< 0.718 && 0.065<y && y<0.085){return 215;} //215
        else if( 0.747<x && x< 0.767 && 0.065<y && y<0.085){return 216;} //216
        else if( 0.842<x && x< 0.862 && 0.065<y && y<0.085){return 217;} //217
        else if( 0.167<x && x< 0.190 && 0.145<y && y<0.165){return 301;} //301
        else if( 0.167<x && x< 0.190 && 0.215<y && y<0.235){return 302;} //302
        else if( 0.167<x && x< 0.190 && 0.293<y && y<0.313){return 303;} //303
        else if( 0.167<x && x< 0.190 && 0.363<y && y<0.383){return 304;} //304
        else if( 0.167<x && x< 0.190 && 0.517<y && y<0.537){return 305;} //305
        else if( 0.167<x && x< 0.190 && 0.62<y && y<0.64){return 306;} //306
        else if( 0.167<x && x< 0.190 && 0.731<y && y<0.751){return 307;} //307
        else if( 0.167<x && x< 0.190 && 0.803<y && y<0.823){return 308;} //308
        else if( 0.124<x && x< 0.144 && 0.733<y && y<0.753){return 401;} //401
        else if( 0.22<x && x< 0.24 && 0.733<y && y<0.753){return 402;} //402
        else if( 0.261<x && x< 0.281 && 0.733<y && y<0.753){return 403;} //403
        else if( 0.323<x && x< 0.343 && 0.733<y && y<0.753){return 404;} //404
        else if( 0.371<x && x< 0.391 && 0.733<y && y<0.753){return 405;} //405
        else if( 0.421<x && x< 0.441 && 0.733<y && y<0.753){return 406;} //406
        else if( 0.475<x && x< 0.495 && 0.733<y && y<0.753){return 407;} //407
        else if( 0.592<x && x< 0.612 && 0.733<y && y<0.753){return 408;} //408
        else if( 0.643<x && x< 0.663 && 0.733<y && y<0.753){return 409;} //409
        else if( 0.697<x && x< 0.717 && 0.733<y && y<0.753){return 410;} //410
        else if( 0.747<x && x< 0.767 && 0.733<y && y<0.753){return 411;} //411
        else if( 0.747<x && x< 0.767 && 0.619<y && y<0.639){return 412;} //412
        else if( 0.747<x && x< 0.767 && 0.529<y && y<0.549){return 413;} //413
        else if( 0.747<x && x< 0.767 && 0.441<y && y<0.461){return 414;} //414
        else if( 0.747<x && x< 0.767 && 0.363<y && y<0.383){return 415;} //415
        else if( 0.747<x && x< 0.767 && 0.293<y && y<0.313){return 416;} //416
        else if( 0.747<x && x< 0.767 && 0.153<y && y<0.173){return 417;} //417
        else if( 0.261<x && x< 0.281 && 0.145<y && y<0.165){return 501;} //501
        else if( 0.261<x && x< 0.281 && 0.215<y && y<0.235){return 502;} //502
        else if( 0.261<x && x< 0.281 && 0.293<y && y<0.313){return 503;} //503
        else if( 0.261<x && x< 0.281 && 0.363<y && y<0.383){return 504;} //504
        else if( 0.261<x && x< 0.281 && 0.517<y && y<0.537){return 505;} //505
        else if( 0.261<x && x< 0.281 && 0.62<y && y<0.64){return 506;} //506
        else if( 0.261<x && x< 0.281 && 0.803<y && y<0.823){return 507;} //507
        else if( 0.325<x && x< 0.345 && 0.293<y && y<0.313){return 601;} //601
        else if( 0.325<x && x< 0.345 && 0.363<y && y<0.383){return 602;} //602
        else if( 0.325<x && x< 0.345 && 0.517<y && y<0.537){return 603;} //603
        else if( 0.365<x && x< 0.385 && 0.615<y && y<0.635){return 604;} //604
        else if( 0.421<x && x< 0.441 && 0.619<y && y<0.639){return 605;} //605
        else if( 0.478<x && x< 0.498 && 0.619<y && y<0.639){return 606;} //606
        else if( 0.592<x && x< 0.612 && 0.619<y && y<0.639){return 607;} //607
        else if( 0.644<x && x< 0.664 && 0.619<y && y<0.639){return 608;} //608
        else if( 0.695<x && x< 0.715 && 0.619<y && y<0.639){return 609;} //609
        else if( 0.816<x && x< 0.836 && 0.609<y && y<0.629){return 610;} //610
        else if( 0.844<x && x< 0.864 && 0.541<y && y<0.561){return 611;} //611
        else if( 0.844<x && x< 0.864 && 0.452<y && y<0.472){return 612;} //612
        else if( 0.844<x && x< 0.864 && 0.372<y && y<0.392){return 613;} //613
        else if( 0.844<x && x< 0.864 && 0.293<y && y<0.313){return 614;} //614
        else if( 0.844<x && x< 0.864 && 0.212<y && y<0.232){return 615;} //615
        else if( 0.797<x && x< 0.817 && 0.153<y && y<0.173){return 616;} //616
        else if( 0.697<x && x< 0.717 && 0.153<y && y<0.173){return 617;} //617
        else if( 0.641<x && x< 0.661 && 0.153<y && y<0.173){return 618;} //618
        else if( 0.575<x && x< 0.595 && 0.153<y && y<0.173){return 619;} //619
        else if( 0.502<x && x< 0.522 && 0.153<y && y<0.173){return 620;} //620
        else if( 0.422<x && x< 0.442 && 0.153<y && y<0.173){return 621;} //621
        else if( 0.347<x && x< 0.367 && 0.168<y && y<0.188){return 622;} //622
        else if( 0.376<x && x< 0.396 && 0.293<y && y<0.313){return 701;} //701
        else if( 0.421<x && x< 0.441 && 0.293<y && y<0.313){return 702;} //702
        else if( 0.502<x && x< 0.522 && 0.293<y && y<0.313){return 703;} //703
        else if( 0.573<x && x< 0.593 && 0.293<y && y<0.313){return 704;} //704
        else if( 0.643<x && x< 0.663 && 0.293<y && y<0.313){return 705;} //705
        else if( 0.693<x && x< 0.713 && 0.293<y && y<0.313){return 706;} //706
        else if( 0.792<x && x< 0.812 && 0.293<y && y<0.313){return 707;} //707
        else if( 0.567<x && x< 0.587 && 0.875<y && y<0.895){return 801;} //801
        else if( 0.643<x && x< 0.663 && 0.875<y && y<0.895){return 802;} //802
        else if( 0.643<x && x< 0.663 && 0.802<y && y<0.822){return 803;} //803
        else if( 0.643<x && x< 0.663 && 0.529<y && y<0.549){return 804;} //804
        else if( 0.643<x && x< 0.663 && 0.439<y && y<0.459){return 805;} //805
        else if( 0.643<x && x< 0.663 && 0.361<y && y<0.381){return 806;} //806
        else if( 0.421<x && x< 0.441 && 0.801<y && y<0.821){return 901;} //901
        else if( 0.421<x && x< 0.441 && 0.517<y && y<0.537){return 902;} //902
        else if( 0.421<x && x< 0.441 && 0.36<y && y<0.38){return 903;} //903
        else if( 0.421<x && x< 0.441 && 0.214<y && y<0.234){return 904;} //904

        else{ return 1000; }

    }

}