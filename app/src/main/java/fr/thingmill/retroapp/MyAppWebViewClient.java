package fr.thingmill.retroapp;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyAppWebViewClient extends WebViewClient {

    @Override
    /*
     * La fonction shouldOverrideUrlLoading permet de restreindre l'url configurée avec loadurl
     * à une chaîne de caractère précise, soit le nom de domaine dans le script suivant
     */
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(Uri.parse(url).getHost().endsWith("thibautlombard.space")) {
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}