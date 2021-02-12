/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.time.LocalDate;
import java.util;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart;
import javafx.scene.control;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author RABİA
 */
public class mainController implements Initializable {

    public DatePicker date_picker_1;
    public DatePicker date_picker_2;
    public BarChart chrt_bar;
    public PieChart chrt_pie;
    @FXML
    private Button btn_ekle;
    @FXML
    private Button btn_sil;
    @FXML
    private Button btn_guncelle;
    @FXML
    private Button btn_sorgula;
    @FXML
    private TableView<Hasta> table_kisiler;
    @FXML
    private CheckBox check_teshis;
    @FXML
    private Slider sld_derece;
    @FXML
    private Label lbl_derece;
    @FXML
    private ComboBox<String> cmb_sehir;
    @FXML
    private RadioButton rdo_kadın;
    @FXML
    private RadioButton rdo_erkek;
    @FXML
    private Label lbl_cinsiyet;
    @FXML
    private Label lbl_meslek;
    @FXML
    private RadioButton rdo_isci;
    @FXML
    private RadioButton rdo_memur;
    @FXML
    private RadioButton rdo_emekli;
    @FXML
    private RadioButton rdo_ogrenci;
    

    @FXML
    private TableColumn<?, ?> kln_hstAdı;
    @FXML
    private TableColumn<?, ?> kln_memleket;
    @FXML
    private TableColumn<?, ?> kln_meslek;
    @FXML
    private TableColumn<?, ?> kln_cinsiyet;
    @FXML
    private TableColumn<?, ?> kln_ates;
    @FXML
    private TableColumn<?, ?> kln_tarih;
    @FXML
    private TableColumn<Hasta, Boolean> kln_teshis;
    @FXML
    private Label lbl_hastaAdı;
    @FXML
    private TextField txt_hstAd;
    @FXML
    private ToggleGroup grp_cinsiyet;
    @FXML
    private ToggleGroup grp_meslek;
    
    private float derece=36.5f;
    
    private Hasta secili_hasta = null;
    @FXML
    private Label lbl_ort_ates;
    @FXML
    private Label lbl_ort_sayi;

    private HashMap<String,Integer> sehir_hasta_sayisi;
    private ObservableList<Hasta> veriler;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        veriler = FXCollections.observableArrayList();
        sehir_hasta_sayisi = new HashMap<>();

        CategoryAxis xAxis    = new CategoryAxis();
        xAxis.setLabel("Şehirler");

        NumberAxis YAxis    = new NumberAxis();
        YAxis.setLabel("Hasta Sayısı");


        sehir_hasta_sayisi.put("Diyarbakır",0);
        sehir_hasta_sayisi.put("Ankara",0);
        sehir_hasta_sayisi.put("İzmir",0);
        sehir_hasta_sayisi.put("Bursa",0);
        sehir_hasta_sayisi.put("Kırıkkale",0);


        ObservableList sehir_list =  FXCollections.observableArrayList();
        sehir_list.add("Diyarbakır");
        sehir_list.add("Ankara");
        sehir_list.add("İzmir");
        sehir_list.add("Bursa");
        sehir_list.add("Kırıkkale");


        cmb_sehir.getItems().addAll(sehir_list);
        
        table_kisiler.setEditable(false);
        
        sld_derece.valueProperty().addListener((
            ObservableValue<? extends Number> ov, 
            Number old_val, Number new_val) -> {
                derece = new_val.floatValue();
                lbl_derece.setText(String.format("%.1f Derece", new_val));
                        
        });
    


        kln_hstAdı.setCellValueFactory(new PropertyValueFactory<>("isim"));
        kln_memleket.setCellValueFactory(new PropertyValueFactory<>("memleket"));
        kln_meslek.setCellValueFactory(new PropertyValueFactory<>("meslek"));
        kln_cinsiyet.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
        kln_ates.setCellValueFactory(new PropertyValueFactory<>("ates"));
        kln_teshis.setCellValueFactory(new PropertyValueFactory<>("teshis"));
        kln_tarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));

        table_kisiler.setItems(veriler);


            veriler.add(new Hasta("Rabia Baruğ", "Kırıkkale", "ÖĞRENCİ", "KADIN", (float) 33.1, true, LocalDate.of(2020, 2,25 )));
            veriler.add(new Hasta("Rabia Baruğ", "Kırıkkale", "ÖĞRENCİ", "KADIN", (float) 33.1, true, LocalDate.of(2020, 2,27 )));
            veriler.add(new Hasta("Rabia Baruğ", "Kırıkkale", "ÖĞRENCİ", "KADIN", (float) 33.1, true, LocalDate.of(2020, 2,29 )));
//          veriler.add(new Hasta("Onur Talan", "Diyarbakır", "ÖĞRENCİ", "ERKEK", (float) 26, false));
//         veriler.add(new Hasta("İlhami Önen", "Diyarbakır", "MEMUR", "ERKEK", (float) 46.6, true));
//        veriler.add(new Hasta("Özge Yılmaz", "İzmir", "MEMUR", "KADIN", (float) 40, true));
//        veriler.add(new Hasta("Emine Burhan", "Kırıkkale", "EMEKLİ", "KADIN", (float) 30.5, false));
//        veriler.add(new Hasta("Ebru Yeşil", "Bursa", "İŞÇİ", "KADIN", (float) 24.3, false));
//        veriler.add(new Hasta("Elif Naz", "Ankara", "ÖĞRENCİ", "KADIN", (float) 36.4, true));
//        veriler.add(new Hasta("Süleyman Can", "Bursa", "EMEKLİ", "ERKEK", (float) 39, true));
//        veriler.add(new Hasta("Kenan Ali", "Bursa", "MEMUR", "ERKEK", (float) 28, false));
//        veriler.add(new Hasta("Sena Ateş", "İzmir", "ÖĞRENCİ", "KADIN", (float) 32, true));
//        veriler.add(new Hasta("Mert Ateş", "Diyarbakır", "İŞÇİ", "ERKEK", (float) 38, true));
        



        SehirGrafigiGoruntule();
        
        
        table_kisiler.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1) { // eger sol tikla bir kere tiklandiysa

                Hasta h = (Hasta) table_kisiler.getSelectionModel().getSelectedItem(); // secilen kisinin bilgileri alındı
                secili_hasta = h; // secilen kisi statik degiskenine atildi
                HastaGoruntule(h);

            }
        });

        veriler.addListener(new ListChangeListener<Hasta>() {
            @Override
            public void onChanged(Change<? extends Hasta> change) {
                while(change.next()){
                    SehirGrafigiGoruntule();
                }
            }
        });



     
    }    



    private void SehirGrafigiGoruntule(){


        sehir_hasta_sayisi.replaceAll( (k,v)->v=0 );

        int sayi;
        for (Hasta h:veriler) {

            if(h.isTeshis()){
                sayi = sehir_hasta_sayisi.get(h.getMemleket());
                sehir_hasta_sayisi.replace(h.getMemleket(),++sayi);
            }
        }


        XYChart.Series data_series = new XYChart.Series();
        Set set = sehir_hasta_sayisi.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry map_entry = (Map.Entry)iterator.next();

            String sehir = String.valueOf(map_entry.getKey());

            sayi = (int)map_entry.getValue();

            data_series.getData().add(new XYChart.Data<String,Integer>(sehir,sayi));
        }
        chrt_bar.getData().clear();
        chrt_bar.getData().add(data_series);

    }

    private void HastaGoruntule(Hasta hasta){
        txt_hstAd.setText(hasta.getIsim());
 
        if(hasta.getCinsiyet().equals("KADIN"))
            grp_cinsiyet.selectToggle(rdo_kadın);
        else
            grp_cinsiyet.selectToggle(rdo_erkek);
            
        ObservableList meslekler = grp_meslek.getToggles();
        
        for(int i = 0; i<meslekler.size();i++){
            ToggleButton t = (ToggleButton) meslekler.get(i);
            if(t.getText().equals(hasta.getMeslek())){
                t.setSelected(true);
            }
        }
        
        
        sld_derece.setValue(hasta.getAtes());
        
        check_teshis.fire();
        
        cmb_sehir.getSelectionModel().select( hasta.getMemleket());

        date_picker_1.setValue(hasta.getTarih());
    }


    
    private Hasta HastaOlustur(){
        String isim = txt_hstAd.getText();//

        RadioButton rdo_secili_cinsiyet = (RadioButton) grp_cinsiyet.getSelectedToggle();
        String cinsiyet = rdo_secili_cinsiyet.getText();

        RadioButton rdo_secili_meslek = (RadioButton) grp_meslek.getSelectedToggle();
        String meslek = rdo_secili_meslek.getText();

        String memleket = String.valueOf(cmb_sehir.getValue());

        boolean pozitif_mi = check_teshis.isSelected();



        return new Hasta(isim, memleket, meslek, cinsiyet, derece, pozitif_mi,date_picker_1.getValue());


    }



    @FXML
    private void BtnEkleTiklandi(ActionEvent event) {
        
        

               
        Hasta eklenecek_hasta = HastaOlustur();
        
        veriler.add(eklenecek_hasta);


        
        Alert mesaj = new Alert(Alert.AlertType.INFORMATION);
        mesaj.setHeaderText("Kayıt ekleme başarılı !!!");
        mesaj.showAndWait();
        
    }

    @FXML
    private void BtnSilTiklandi(ActionEvent event) {
        
        if(secili_hasta != null){
            Alert mesaj = new Alert(Alert.AlertType.CONFIRMATION);
            mesaj.setHeaderText(secili_hasta.getIsim()+" adlı hastayı silmek istediğinizden emin misiniz ?");
            
            Optional<ButtonType> sonuc = mesaj.showAndWait();
            
            if(sonuc.get() == ButtonType.OK){
              veriler.remove(secili_hasta);
              secili_hasta = null;
            }
        }
        
        
    }

    @FXML
    private void BtnGuncelleTiklandi(ActionEvent event) {
        
        
        Hasta h = HastaOlustur();
        
        veriler.set(veriler.indexOf(secili_hasta),h);
        
        
    }

    @FXML
    private void BtnSorgulaTiklandi(ActionEvent event) {
        String sehir = cmb_sehir.getValue();
        
        double toplam_ates=0;
        
        int toplam_sayi=0;
        
        for(Object o: veriler){
            
            Hasta h = (Hasta)o;
            if(h.getMemleket().equals(sehir)){
                toplam_sayi++;
                toplam_ates+=h.getAtes();
                        
            }
            
            lbl_ort_sayi.setText("Toplam Sayi: "+toplam_sayi);
            lbl_ort_ates.setText(String.format("Ortalama Ateş: %.1f",toplam_ates/toplam_sayi));

            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();


            Set set = sehir_hasta_sayisi.entrySet();
            Iterator iterator = set.iterator();

            String s;
            int sayi;
            while (iterator.hasNext()){
                Map.Entry map_entry = (Map.Entry)iterator.next();

                 s = String.valueOf(map_entry.getKey());

                sayi = (int)map_entry.getValue();

                if(sayi !=0)
                    pieChartData.add(new PieChart.Data(s,sayi*10));

            }

            chrt_pie.getData().clear();
            chrt_pie.getData().addAll(pieChartData);

    }
}

    public void DatePickerChange(ActionEvent actionEvent) {

        LocalDate ilk_zaman = date_picker_1.getValue();

        LocalDate ikinci_zaman = date_picker_2.getValue();

        ObservableList<Hasta> yeni_veriler = FXCollections.observableArrayList();

        for (Hasta h:veriler) {
            if(ilk_zaman.isBefore(h.getTarih())&&ikinci_zaman.isAfter(h.getTarih()))
                yeni_veriler.add(h);

        }

        new Alert(Alert.AlertType.INFORMATION,"Yeni veriler: "+yeni_veriler.size(),ButtonType.OK).showAndWait();


        if(yeni_veriler.size() > 0){
            veriler.clear();
            veriler.addAll(yeni_veriler);
        }

        else{
             new Alert(Alert.AlertType.INFORMATION,"Girilen Aralıkta Hasta Bulunamadı !",ButtonType.OK).showAndWait();
        }

    }
}