package com.example.infopariwisataindonesia;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WisataAdapter.OnWisataListener {

    private RecyclerView recyclerView;
    private WisataAdapter adapter;
    private List<TempatWisata> daftarWisata;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siapkanData();

        recyclerView = findViewById(R.id.recycler_view_wisata);
        setupRecyclerView();

        searchView = findViewById(R.id.search_view);
        setupSearchView();
    }

    private void setupRecyclerView() {
        adapter = new WisataAdapter(this, daftarWisata, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterDaftar(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterDaftar(newText);
                return true;
            }
        });
    }

    private void filterDaftar(String teks) {
        List<TempatWisata> daftarTerfilter = new ArrayList<>();
        for (TempatWisata item : daftarWisata) {
            if (item.getNama().toLowerCase().contains(teks.toLowerCase())) {
                daftarTerfilter.add(item);
            }
        }
        adapter.filterList(daftarTerfilter);
    }

    private void siapkanData() {
        daftarWisata = new ArrayList<>();

        daftarWisata.add(new TempatWisata(
                "Raja Ampat",
                "Kepulauan surga penyelam di Papua Barat.",
                4.9,
                R.drawable.raja_ampat,
                "Raja Ampat adalah kepulauan yang terdiri dari empat pulau utama dan ratusan pulau kecil di lepas pantai Papua Barat. Dikenal sebagai salah satu lokasi penyelaman terbaik di dunia dengan keanekaragaman hayati laut terkaya di planet ini.",
                "Oktober - April (Musim Kering)",
                "Kabupaten Raja Ampat, Papua Barat Daya, Indonesia",
                "084543231222",
                "geo:-0.5562,130.5187?q=Raja+Ampat+Islands"
        ));
        daftarWisata.add(new TempatWisata(
                "Candi Borobudur",
                "Candi Buddha terbesar di dunia, warisan UNESCO.",
                4.8,
                R.drawable.candi_borobudur,
                "Candi Borobudur adalah monumen Buddha Mahayana abad ke-9 di Magelang, Jawa Tengah. Monumen ini terdiri dari sembilan teras berundak, tiga pelataran melingkar di puncaknya, dan dihiasi dengan 2.672 panel relief serta 504 arca Buddha.",
                "Pagi hari (Sunrise) atau Sore hari",
                "Jl. Badrawati, Kw. Candi Borobudur, Borobudur, Magelang",
                "083293788266",
                "geo:-7.6079,110.2038?q=Candi+Borobudur"
        ));
        daftarWisata.add(new TempatWisata(
                "Gunung Bromo",
                "Gunung berapi aktif dengan lautan pasir ikonik.",
                4.7,
                R.drawable.gunung_bromo,
                "Bagian dari Taman Nasional Bromo Tengger Semeru, gunung ini terkenal dengan pemandangan matahari terbitnya yang spektakuler dari Puncak Penanjakan, kawah aktif, dan lautan pasir (kaldera) yang luas.",
                "April - Oktober (Musim Kering)",
                "Taman Nasional Bromo Tengger Semeru, Jawa Timur",
                "081238767543",
                "geo:-7.9425,112.9530?q=Gunung+Bromo"
        ));
        daftarWisata.add(new TempatWisata(
                "Taman Nasional Komodo",
                "Habitat asli kadal purba, Komodo Dragon.",
                4.8,
                R.drawable.pulau_komodo,
                "Terletak di Kepulauan Nusa Tenggara, taman nasional ini adalah rumah bagi lebih dari 5.000 ekor komodo. Selain itu, taman ini menawarkan pemandangan bukit sabana yang kering, pantai pink (Pink Beach), dan spot diving kelas dunia.",
                "April - Desember",
                "Nusa Tenggara Timur, Indonesia",
                "081385241004",
                "geo:-8.5447,119.4884?q=Taman+Nasional+Komodo"
        ));
        daftarWisata.add(new TempatWisata(
                "Tanah Lot",
                "Pura Hindu di atas batu karang di Bali.",
                4.6,
                R.drawable.tanah_lot,
                "Salah satu ikon pariwisata Bali, Pura Tanah Lot berdiri kokoh di atas batu karang besar di tengah laut. Tempat ini sangat populer untuk menikmati pemandangan matahari terbenam (sunset) yang dramatis.",
                "Sore hari (Sunset)",
                "Beraban, Kediri, Kabupaten Tabanan, Bali",
                "082361880361",
                "geo:-8.6212,115.0868?q=Pura+Tanah+Lot"
        ));
        daftarWisata.add(new TempatWisata(
                "Danau Toba",
                "Danau vulkanik terbesar di Asia Tenggara.",
                4.7,
                R.drawable.danau_toba,
                "Danau Toba adalah kaldera supervulkan raksasa di Sumatera Utara. Di tengah danau ini terdapat Pulau Samosir, sebuah pulau vulkanik yang hampir seukuran dengan Singapura, yang merupakan pusat kebudayaan Batak Toba.",
                "Mei - September",
                "Sumatera Utara, Indonesia",
                "089767666541",
                "geo:2.6030,98.8354?q=Danau+Toba"
        ));
        daftarWisata.add(new TempatWisata(
                "Gili Trawangan",
                "Pulau pesta terbesar di antara tiga Gili Lombok.",
                4.5,
                R.drawable.gili_trawangan,
                "Gili Trawangan terkenal dengan pantainya yang berpasir putih, air laut biru jernih, dan kehidupan malamnya yang semarak. Pulau ini bebas dari kendaraan bermotor, dengan transportasi utama berupa sepeda dan cidomo (kereta kuda).",
                "Mei - Oktober",
                "Gili Indah, Pemenang, Kabupaten Lombok Utara, NTB",
                "083565778112",
                "geo:-8.3491,116.0396?q=Gili+Trawangan"
        ));
        daftarWisata.add(new TempatWisata(
                "Kawah Ijen",
                "Kawah vulkanik dengan fenomena api biru.",
                4.7,
                R.drawable.kawah_ijen,
                "Terletak di perbatasan Banyuwangi dan Bondowoso, Kawah Ijen memiliki danau kawah asam terbesar di dunia. Tempat ini terkenal dengan fenomena 'blue fire' (api biru) langka yang hanya bisa dilihat pada dini hari.",
                "Dini hari (untuk Blue Fire)",
                "Taman Nasional Ijen, Jawa Timur",
                "086767543109",
                "geo:-8.0583,114.2428?q=Kawah+Ijen"
        ));
        daftarWisata.add(new TempatWisata(
                "Candi Prambanan",
                "Kompleks candi Hindu terbesar di Indonesia.",
                4.8,
                R.drawable.candi_prambanan,
                "Dibangun pada abad ke-9 Masehi, kompleks candi ini didedikasikan untuk Trimurti (Brahma, Wisnu, Siwa). Arsitekturnya yang tinggi dan ramping, dengan candi Siwa sebagai candi utama setinggi 47 meter, sangat memukau.",
                "Sore hari",
                "Jl. Raya Solo - Yogyakarta No.16, Kranggan, Sleman",
                "087274496401",
                "geo:-7.7520,110.4915?q=Candi+Prambanan"
        ));
        daftarWisata.add(new TempatWisata(
                "Ubud",
                "Pusat seni dan budaya di jantung Bali.",
                4.6,
                R.drawable.ubud_bali,
                "Ubud dikelilingi oleh sawah terasering yang hijau dan hutan lebat. Tempat ini dikenal sebagai pusat kerajinan tangan, galeri seni, yoga, dan retret kesehatan. Tempat ikonik termasuk Monkey Forest dan Sawah Terasering Tegalalang.",
                "Sepanjang tahun",
                "Kabupaten Gianyar, Bali, Indonesia",
                "081765431111",
                "geo:-8.5069,115.2625?q=Ubud"
        ));
        daftarWisata.add(new TempatWisata(
                "Labuan Bajo",
                "Pintu gerbang menuju Taman Nasional Komodo.",
                4.7,
                R.drawable.labuan_bajo,
                "Kota pelabuhan kecil di ujung barat Flores ini telah berkembang pesat menjadi pusat wisata. Dari sini, wisatawan dapat berlayar (liveaboard) ke Pulau Komodo, Pulau Padar, Pink Beach, dan Manta Point.",
                "April - Oktober",
                "Kabupaten Manggarai Barat, Nusa Tenggara Timur",
                "081232777654",
                "geo:-8.4979,119.8856?q=Labuan+Bajo"
        ));
        daftarWisata.add(new TempatWisata(
                "Desa Wae Rebo",
                "Desa adat terpencil di atas awan Flores.",
                4.9,
                R.drawable.wae_rebo,
                "Terletak di ketinggian 1.200 mdpl, desa ini terkenal dengan 7 rumah adat Mbaru Niang yang berbentuk kerucut unik. Untuk mencapainya, diperlukan trekking selama 2-3 jam menembus hutan lebat.",
                "Mei - September (Musim Kering)",
                "Satar Lenda, Satar Mese Barat, Kabupaten Manggarai, NTT",
                "083657891098",
                "geo:-8.7618,120.2858?q=Wae+Rebo+Village"
        ));
        daftarWisata.add(new TempatWisata(
                "Tana Toraja",
                "Dataran tinggi dengan ritual pemakaman unik.",
                4.8,
                R.drawable.tana_toraja,
                "Terletak di Sulawesi Selatan, Tana Toraja terkenal dengan rumah adat Tongkonan dan ritual pemakaman (Rambu Solo') yang rumit dan meriah. Kuburan batu di tebing (Londa) juga menjadi daya tarik utama.",
                "Juni - September (Musim Rambu Solo')",
                "Kabupaten Tana Toraja, Sulawesi Selatan",
                "081232761999",
                "geo:-3.0903,119.8055?q=Tana+Toraja"
        ));
        daftarWisata.add(new TempatWisata(
                "Taman Laut Bunaken",
                "Surga snorkeling dan diving di Sulawesi Utara.",
                4.8,
                R.drawable.taman_laut_bunaken,
                "Bunaken memiliki salah satu dinding terumbu karang (coral wall) vertikal terdalam di dunia dan keanekaragaman hayati laut yang sangat tinggi. Ini adalah salah satu spot diving paling populer di Indonesia.",
                "Maret - Oktober",
                "Manado, Sulawesi Utara, Indonesia",
                "083456121989",
                "geo:1.6919,124.7570?q=Bunaken+Marine+Park"
        ));
        daftarWisata.add(new TempatWisata(
                "Kepulauan Derawan",
                "Gugusan pulau indah di Kalimantan Timur.",
                4.7,
                R.drawable.kepulauan_derawan,
                "Terkenal dengan Pulau Kakaban (danau ubur-ubur tanpa sengat), Maratua (resort mewah dan laguna), serta Sangalaki (spot melihat pari manta). Penyu hijau juga sering terlihat bertelur di pantai Derawan.",
                "Maret - Oktober",
                "Kabupaten Berau, Kalimantan Timur",
                "089767509012",
                "geo:2.2874,118.2142?q=Derawan+Islands"
        ));
        daftarWisata.add(new TempatWisata(
                "Taman Nasional Tanjung Puting",
                "Rumah bagi populasi orangutan liar.",
                4.9,
                R.drawable.tanjung_puting,
                "Terletak di Kalimantan Tengah, taman nasional ini adalah pusat rehabilitasi orangutan terbesar di dunia (Camp Leakey). Wisatawan dapat menyusuri Sungai Sekonyer dengan perahu klotok untuk melihat orangutan dan bekantan di habitat aslinya.",
                "Juni - September (Musim Kering)",
                "Kabupaten Kotawaringin Barat, Kalimantan Tengah",
                "086121212876",
                "geo:-3.0208,111.9488?q=Tanjung+Puting+National+Park"
        ));
        daftarWisata.add(new TempatWisata(
                "Kawah Putih",
                "Danau kawah vulkanik dengan warna putih kehijauan.",
                4.6,
                R.drawable.kawah_putih,
                "Berada di Ciwidey, Bandung, danau ini terbentuk dari letusan Gunung Patuha. Warna airnya yang sureal (bisa berubah-ubah) dan pemandangan kabut mistis menjadikannya spot foto yang sangat populer.",
                "Pagi hari (07.00 - 10.00)",
                "Jl. Raya Ciwidey Patengan Km 11, Bandung, Jawa Barat",
                "087131212104",
                "geo:-7.1661,107.4020?q=Kawah+Putih"
        ));
        daftarWisata.add(new TempatWisata(
                "Pulau Weh (Sabang)",
                "Titik nol kilometer Indonesia di ujung barat.",
                4.7,
                R.drawable.pulau_weh,
                "Pulau di ujung utara Sumatera ini terkenal dengan Tugu Nol Kilometer. Selain itu, Pantai Iboih dan Pulau Rubiah menawarkan aktivitas snorkeling dan diving yang menakjubkan dengan terumbu karang yang masih sangat sehat.",
                "April - November",
                "Sabang, Aceh, Indonesia",
                "08123390076",
                "geo:5.8260,95.3188?q=Pulau+Weh"
        ));
        daftarWisata.add(new TempatWisata(
                "Pulau Belitung",
                "Pantai dengan formasi batu granit raksasa.",
                4.7,
                R.drawable.pulau_belitung,
                "Dipopulerkan oleh film Laskar Pelangi, Belitung mempesona dengan pantai-pantainya yang unik seperti Pantai Tanjung Tinggi dan Tanjung Kelayang. Pulau Lengkuas dengan mercusuar tuanya juga wajib dikunjungi.",
                "April - September",
                "Provinsi Kepulauan Bangka Belitung",
                "086754123123",
                "geo:-2.8879,107.9048?q=Belitung"
        ));
        daftarWisata.add(new TempatWisata(
                "Dataran Tinggi Dieng",
                "Negeri di atas awan dengan candi-candi kuno.",
                4.6,
                R.drawable.dataran_tinggi_dieng,
                "Terletak di Jawa Tengah, Dieng adalah kaldera raksasa dengan pemandangan alam yang menakjubkan, seperti Telaga Warna, Kawah Sikidang, dan Candi Arjuna (kompleks candi Hindu tertua di Jawa).",
                "Juli - Agustus (Musim Kering & Dingin)",
                "Kabupaten Banjarnegara & Wonosobo, Jawa Tengah",
                "087627666524",
                "geo:-7.2098,109.9063?q=Dataran+Tinggi+Dieng"
        ));
        daftarWisata.add(new TempatWisata(
                "Taman Nasional Ujung Kulon",
                "Habitat terakhir Badak Jawa bercula satu.",
                4.8,
                R.drawable.ujung_kulon,
                "Warisan Dunia UNESCO ini adalah suaka margasatwa penting di Banten. Selain menjadi rumah bagi badak Jawa yang terancam punah, wisatawan dapat menikmati Pulau Peucang dan kano di Sungai Cigenter.",
                "April - Oktober",
                "Kabupaten Pandeglang, Banten",
                "086565723093",
                "geo:-6.7533,105.3347?q=Taman+Nasional+Ujung+Kulon"
        ));
        daftarWisata.add(new TempatWisata(
                "Mandalika",
                "Kawasan wisata super prioritas dengan sirkuit MotoGP.",
                4.5,
                R.drawable.kuta_mandalika,
                "Terletak di Lombok Selatan, Mandalika terkenal dengan Sirkuit Pertamina Mandalika, Pantai Kuta Lombok, dan Bukit Merese. Kawasan ini menawarkan pantai-pantai indah dengan pasir seputih merica.",
                "Mei - September",
                "Pujut, Kabupaten Lombok Tengah, NTB",
                "081234245623",
                "geo:-8.8913,116.2821?q=Mandalika"
        ));
        daftarWisata.add(new TempatWisata(
                "Nusa Penida",
                "Pulau eksotis di tenggara Bali.",
                4.7,
                R.drawable.nusa_penida,
                "Nusa Penida terkenal dengan tebing-tebing kapur yang dramatis dan pemandangan laut yang luar biasa. Spot ikonik termasuk Kelingking Beach (tebing T-Rex), Angel's Billabong, dan Broken Beach (Pasih Uug).",
                "April - Oktober",
                "Kabupaten Klungkung, Bali",
                "085434109091",
                "geo:-8.7350,115.5566?q=Nusa+Penida"
        ));
        daftarWisata.add(new TempatWisata(
                "Ngarai Sianok",
                "Lembah curam di Bukittinggi, Sumatera Barat.",
                4.7,
                R.drawable.ngarai_sianok,
                "Ngarai Sianok adalah lembah hijau subur yang membentang sepanjang 15 km dengan dinding tebing setinggi 100-120 meter. Pemandangan terbaik bisa dinikmati dari Taman Panorama, yang juga memiliki Lobang Jepang.",
                "Pagi atau Sore hari",
                "Bukittinggi, Agam, Sumatera Barat",
                "089875430712",
                "geo:-0.3013,100.3606?q=Ngarai+Sianok"
        ));
        daftarWisata.add(new TempatWisata(
                "Karimunjawa",
                "Gugusan kepulauan dengan laut jernih di Jawa.",
                4.6,
                R.drawable.pulau_karimunjawa,
                "Taman Nasional Karimunjawa adalah surga bagi pecinta pantai dan snorkeling. Terdiri dari 27 pulau, tempat ini menawarkan pantai pasir putih, air laut gradasi biru-tosca, dan terumbu karang yang indah.",
                "April - Oktober (Musim Kering)",
                "Kabupaten Jepara, Jawa Tengah",
                "087654120903",
                "geo:-5.8396,110.4444?q=Karimunjawa"
        ));
    }

    @Override
    public void onWisataClick(int position) {
        TempatWisata wisataDiKlik = adapter.getItemAt(position);
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("DATA_WISATA", wisataDiKlik);
        startActivity(intent);
    }
}