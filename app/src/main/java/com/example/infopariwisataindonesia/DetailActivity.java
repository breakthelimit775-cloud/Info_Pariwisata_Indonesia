package com.example.infopariwisataindonesia;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    private TempatWisata wisata;

    private TextView tvDeskripsi, tvWaktu, tvAlamat, tvTelepon, tvToolbarTitle;
    private ImageView imgHeader;
    private MaterialCardView cardViewMaps, cardViewTelepon;
    private Button btnKembali;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        wisata = (TempatWisata) getIntent().getSerializableExtra("DATA_WISATA");

        if (wisata == null) {
            finish();
            return;
        }

        inisialisasiViews();
        isiData();
        setupListeners();
        setupToolbar();
    }

    private void inisialisasiViews() {
        tvDeskripsi = findViewById(R.id.tv_detail_deskripsi);
        tvWaktu = findViewById(R.id.tv_detail_waktu);
        tvAlamat = findViewById(R.id.tv_detail_alamat);
        tvTelepon = findViewById(R.id.tv_detail_telepon);
        imgHeader = findViewById(R.id.img_detail_header);
        cardViewMaps = findViewById(R.id.cardview_maps);
        cardViewTelepon = findViewById(R.id.cardview_telepon);
        btnKembali = findViewById(R.id.btn_detail_kembali);
        appBarLayout = findViewById(R.id.appbar);
        toolbar = findViewById(R.id.toolbar_detail);
        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        tvToolbarTitle = findViewById(R.id.tv_toolbar_title);
    }

    private void isiData() {
        tvDeskripsi.setText(wisata.getDeskripsiPanjang());
        tvWaktu.setText(wisata.getWaktuTerbaik());
        tvAlamat.setText(wisata.getAlamat());
        tvTelepon.setText(wisata.getNomorTelepon());

        collapsingToolbar.setTitle(wisata.getNama());
        tvToolbarTitle.setText(wisata.getNama());

        Glide.with(this)
                .load(wisata.getImageUrl())
                .into(imgHeader);

        if ("N/A".equals(wisata.getNomorTelepon())) {
            cardViewTelepon.setVisibility(View.GONE);
        } else {
            cardViewTelepon.setVisibility(View.VISIBLE);
        }
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    tvToolbarTitle.setVisibility(View.VISIBLE);
                    isShow = true;
                } else if (isShow) {
                    tvToolbarTitle.setVisibility(View.GONE);
                    isShow = false;
                }
            }
        });
    }

    private void setupListeners() {
        btnKembali.setOnClickListener(v -> finish());

        cardViewTelepon.setOnClickListener(v -> {
            String nomor = "tel:" + wisata.getNomorTelepon();
            Intent intentPanggil = new Intent(Intent.ACTION_DIAL);
            intentPanggil.setData(Uri.parse(nomor));
            try {
                startActivity(intentPanggil);
            } catch (ActivityNotFoundException e) {

            }
        });

        cardViewMaps.setOnClickListener(v -> {
            String geoUriString = wisata.getMapUrl();

            try {
                Uri gmmIntentUri = Uri.parse(geoUriString);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(mapIntent);
            } catch (ActivityNotFoundException e) {
                try {
                    String coords = geoUriString.substring(4, geoUriString.indexOf('?'));
                    String label = geoUriString.substring(geoUriString.indexOf('=') + 1);
                    String webUrl = "https://www.google.com/maps/search/?api=1&query=" + coords + "(" + label + ")";

                    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
                    startActivity(webIntent);
                } catch (ActivityNotFoundException e2) {

                }
            }
        });
    }
}