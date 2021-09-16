package pk.wirless.seanet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import pk.wirless.seanet.about.ourDrawerMenus.AboutUs;
import pk.wirless.seanet.about.ourDrawerMenus.ContactUs;
import pk.wirless.seanet.about.ourDrawerMenus.Home;
import pk.wirless.seanet.about.ourDrawerMenus.Locations;
import pk.wirless.seanet.about.ourDrawerMenus.Packages;
import pk.wirless.seanet.about.ourDrawerMenus.PayAsYouUse;
import pk.wirless.seanet.about.ourDrawerMenus.RateApp;
import pk.wirless.seanet.about.ourDrawerMenus.ShareApp;
import pk.wirless.seanet.about.ourDrawerMenus.Technology;
import com.google.android.material.navigation.NavigationView;
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView nav_view;
    int fM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer);
        nav_view = findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);
        drawer.addDrawerListener(toggle);
        toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.syncState();
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();
            nav_view.setCheckedItem(R.id.home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home()).commit();
                fM=0;
                break;
                case R.id.packages:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Packages()).commit();
                fM=1;
                break;
            case R.id.technology:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Technology()).commit();
                fM=2;
                break;
            case R.id.location:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Locations()).commit();
                fM=3;
                break;
            case R.id.pau:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PayAsYouUse()).commit();
                fM=4;
                break;
            case R.id.rate_app:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RateApp()).commit();
                fM=5;
                break;
            case R.id.share_app:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ShareApp()).commit();
                fM=6;
                break;
            case R.id.contact_us:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ContactUs()).commit();
                fM=7;
                break;
            case R.id.about_us:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AboutUs()).commit();
                fM=8;
                break;
            case R.id.logout:
                startActivity(new Intent(MainActivity.this,Login.class));
                finish();
                break;


            default:
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else if (fM>=1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home()).commit();
            fM=0;
        }else
            {
        super.onBackPressed();
        }
    }
}