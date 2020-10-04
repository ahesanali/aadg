package com.saralhisab.androidlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class WebviewActivity extends AppCompatActivity {

    private WebView exampleWebview;
    private String webviewContent = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        exampleWebview = (WebView) findViewById(R.id.example_webview);
        WebSettings exampleWebViewSetting = exampleWebview.getSettings();
        exampleWebViewSetting.setJavaScriptEnabled(true);

        loadHtmlContent();

        exampleWebview.loadDataWithBaseURL(null,webviewContent,"text/html","UTF-8","");

    }

    private  void loadHtmlContent()
    {
        webviewContent = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>An Unordered HTML List</h2>\n" +
                "\n" +
                "<ul>\n" +
                "  <li>Coffee</li>\n" +
                "  <li>Tea</li>\n" +
                "  <li>Milk</li>\n" +
                "</ul>  \n" +
                "\n" +
                "<h2>An Ordered HTML List</h2>\n" +
                "\n" +
                "<ol>\n" +
                "  <li>Coffee</li>\n" +
                "  <li>Tea</li>\n" +
                "  <li>Milk</li>\n" +
                "</ol> \n" +
                "\n" +
                "<button onClick=\"sayHello()\" >Say Hello</button>\n" +
                "\n" +
                "<script language='javascript' type=\"text/javascript\">\n" +
                "\n" +
                "function sayHello()\n" +
                "{\n" +
                "   alert(\"Hello\");\n" +
                "}\n" +
                "</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }
}
