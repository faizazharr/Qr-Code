package id.faiz.www.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class show_tashih_page extends AppCompatActivity {
    public static String URL_LINK ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tashih_page);

        WebView webView = findViewById(R.id.web);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        // Tiga baris di bawah ini agar laman yang dimuat dapat
//        String jq = "jquery:function($(\"#content\").remove()";
        // melakukan zoom.
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        // Baris di bawah untuk menambahkan scrollbar di dalam WebView-nya

        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                    view.loadUrl("javascript:$(document).ready(function() {\n" +
                            "  $('#content').remove();\n" +
                            "  $('.navbar-toggler-icon').remove();\n" +
                            "  $('.purechat-launcher-message').remove();\n" +
                            "  $('#navbarSupportedContent').remove();\n" +
                            "  $('#kotak-login-res').remove();\n" +
                            "  $('#btnLogin').remove();\n" +
                            "  $('#btnRegistrasi').remove();\n" +
                            "  $('#myBtn').remove();\n" +
                            "  $('#myBtn2').remove();\n" +
                            "  $('#footerBox').remove();\n" +
                            "})");
            }
        });
//        webView.loadUrl(jq);
        webView.loadUrl(getIntent().getStringExtra(URL_LINK));
    }
}
