package com.example.mindon.activity

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.example.homemindon.view.MainFragment
import com.example.homemindon.view.ScoresFragment
import com.example.homemindon.view.SkinsFragment
import com.example.homemindon.view.ViewPagerAdapter
import com.example.mindon.R
import com.example.mindon.model.Usuario
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.content_main.*


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private lateinit var auth: FirebaseAuth
    private val referencia = FirebaseDatabase.getInstance().reference
    private lateinit var nome: TextView
    private lateinit var  imagemPerfil: CircleImageView
    private lateinit var  storageReference: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        auth = FirebaseAuth.getInstance()


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

       navView.setNavigationItemSelectedListener(this)

        storageReference =  FirebaseStorage.getInstance().reference

        carregarInformacoesNav();

        setUpTabs()
    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(SkinsFragment(), "")
        adapter.addFragment(MainFragment(), "")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_local_mall_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_sports_esports_24)

        tabs.getTabAt(1)!!.select()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
      when(item.itemId){
            R.id.action_settings -> {
                val intent = Intent(this, ProgressMemoryActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }


    override fun onBackPressed() {
        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.nav_perfil) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        else if (id == R.id.nav_configuracoes) {
            val intent = Intent(applicationContext, SettingsActivity::class.java)
            startActivity(intent)
        } else if(id == R.id.nav_sair){
            val pd = ProgressDialog(this)
            pd.setMessage("Saindo ...")
            pd.show()
            auth.signOut()
            startActivity(Intent(this,CadastroActivity::class.java))
        }else if(id == R.id.nav_ajuda){
            val intent = Intent(applicationContext, AjudaActivity::class.java)
            startActivity(intent)
        }

        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    fun carregarInformacoesNav(){

        /*ccodigo para futura implementação*
        val signInAccount = GoogleSignIn.getLastSignedInAccount(this)

        if(signInAccount != null){
            //referencia da view do nav header
            nome = findViewById(R.id.nav_user_nome)
            //exibe as informações
            nome.text = signInAccount.displayName
            imagemPerfil = findViewById(R.id.img_perfil_home);
            Picasso.get()
                .load(signInAccount.photoUrl)
                .into(imagemPerfil)

        }else{

        }*/


        //acessar a referencia do nó usuarios e seu filho(usuario logados)
        val usuario = referencia.child("usuarios").child(auth.uid!!)

        //cria um listener para o nó
        usuario.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //recupera as informações do firebase e coloca dentro do objeto Usuario
                val user = dataSnapshot.getValue(Usuario::class.java)!!
                //referencia da view do nav header
                nome = findViewById(R.id.nav_user_nome)
                //exibe as informações
                nome.text = user.nome

                if(!user.foto.isEmpty()){
                    imagemPerfil = findViewById(R.id.img_perfil_home);
                    Picasso.get()
                        .load(user.foto)
                        .into(imagemPerfil)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })


    }
}