package scisrc.mobiledev.ecommercelayout

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import scisrc.mobiledev.ecommercelayout.databinding.ActivityMainBinding
import scisrc.mobiledev.ecommercelayout.ui.Home.HomeFragment
import scisrc.mobiledev.ecommercelayout.ui.Product_List.ProductFragment
import scisrc.mobiledev.ecommercelayout.ui.Shopping_cart.ShoppingFragment
import scisrc.mobiledev.ecommercelayout.ui.Favorites.FavoritesFragment
import scisrc.mobiledev.ecommercelayout.ui.Profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup toolbar
        setSupportActionBar(binding.toolbar)

        // Initialize navigation
        drawerLayout = binding.drawerLayout

        // Add hamburger icon
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Navigation Drawer Listener
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment())
                        .commit()
                }
                R.id.nav_product -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ProductFragment())
                        .commit()
                }
                R.id.nav_Shopping_Cart -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ShoppingFragment())
                        .commit()
                }
                R.id.nav_Favorites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FavoritesFragment())
                        .commit()
                }
                R.id.nav_Profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ProfileFragment())
                        .commit()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Load default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
            binding.navView.setCheckedItem(R.id.nav_home)
        }
    }
}