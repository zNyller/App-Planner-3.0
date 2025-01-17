package com.nyller.android.mach4

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.nyller.android.mach4.application.MyApplication
import com.nyller.android.mach4.databinding.ActivityMainBinding
import com.nyller.android.mach4.ui.viewmodel.HabitViewModel

class MainActivity : AppCompatActivity() {

//    private lateinit var dialog: AlertDialog

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mHabitViewModel: HabitViewModel by viewModels {
        HabitViewModel.HabitViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBottomNavigation()

//        binding.habitViewModel = mHabitViewModel

//        val adapter = HabitAdapter(HabitAdapter.HabitClickListener { habit ->
//            mHabitViewModel.onHabitClicked(habit)
//        })
//
//        binding.rvHabits.adapter = adapter
//
//        binding.fabNewHabit.setOnClickListener {
//            val intent = Intent(this, NewHabitActivity::class.java)
//            getResult.launch(intent)
//        }
//
//        mHabitViewModel.allHabits.observe(this) { habits ->
//            habits?.let { adapter.addHeaderAndSubmitList(it) }
//        }
//
//        mHabitViewModel.openHabitDetail.observe(this) { habit ->
//            habit?.let {
//                val intent = Intent(this, EditHabitActivity::class.java)
//                intent.putExtra("HABIT_DETAILS", habit)
//                startActivity(intent)
//                mHabitViewModel.onHabitOpened()
//            }
//        }
//
//    }

//    private fun showHabitDetails(habitSelected: Habit, onHabitStatusChanged: (Habit) -> Unit) {
//
//        //dialog personalizada
//        val build = AlertDialog.Builder(this)
//
//        val dialogCustomBinding: DialogCustomBinding =
//            DialogCustomBinding.inflate(LayoutInflater.from(this))
//
//        dialogCustomBinding.tvHabitNameDialog.text = "Nome: ${habitSelected.name}"
//        dialogCustomBinding.tvHabitTurnDialog.text = "Turno: ${habitSelected.turn}"
//        dialogCustomBinding.tvHabitCategoryDialog.text = "Categoria: ${habitSelected.category}"
//
//        dialogCustomBinding.btnClose.setOnClickListener { dialog.dismiss() }
//        dialogCustomBinding.btnDone.setOnClickListener {
//            if (!habitSelected.done) {
//                dialogCustomBinding.btnDone.text = getString(R.string.concluido)
//                habitSelected.done = !habitSelected.done
//                onHabitStatusChanged(habitSelected)
//                return@setOnClickListener
//            } else {
//                dialogCustomBinding.btnDone.text = getString(R.string.concluir)
//                habitSelected.done = !habitSelected.done
//                onHabitStatusChanged(habitSelected)
//                return@setOnClickListener
//            }
//
//        }
//
//        dialogCustomBinding.btnDelete.setOnClickListener {
//            mHabitViewModel.delete(habitSelected)
//            dialog.dismiss()
//            Toast.makeText(this, "Hábito excluído!", Toast.LENGTH_SHORT).show()
//        }
//
//        build.setView(dialogCustomBinding.root)
//
//        dialog = build.create()
//        dialog.show()
    }

    private fun setupBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)
    }

}