package com.example.warehousemobileapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.warehousemobileapplication.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*

class LoginFragment : Fragment() {
    private var binding: FragmentLoginBinding? = null
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //save inflated view to fragmentBinding
        val fragmentBinding = FragmentLoginBinding.inflate(inflater, container, false)

        auth = FirebaseAuth.getInstance()

        fragmentBinding.btnLogin.setOnClickListener { login() }
        fragmentBinding.txtLoginForgotPassword.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }
        fragmentBinding.txtLoginSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
//            val intent = Intent(context, RegisterActivity::class.java)
//            startActivity(intent)
        }

        //initialize to binding
        binding = fragmentBinding
        //create view with inflated fragmentBinding
        return fragmentBinding.root
    }

    private fun forgotPassword(useremail : EditText){
        if(useremail.text.toString().isEmpty()){
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(useremail.text.toString()).matches()){
            return
        }

        auth.sendPasswordResetEmail(useremail.text.toString()).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Email sent.",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        auth.signOut()
        binding = null
    }

    private fun login(){
        if(txtLoginEmail.text.toString().isEmpty()){
            txtLoginEmail.error = "Please enter your email"
            txtLoginEmail.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(txtLoginEmail.text.toString()).matches()){
            txtLoginEmail.error = "Please enter a valid email"
            txtLoginEmail.requestFocus()
            return
        }
        if(txtLoginPassword.text.toString().isEmpty()){
            txtLoginPassword.error = "Please enter your password"
            txtLoginPassword.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(txtLoginEmail.text.toString(), txtLoginPassword.text.toString())
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                    Toast.makeText(context, "Login successfully.",
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(currentUser : FirebaseUser?){
        if(currentUser != null){
            if(currentUser.isEmailVerified){
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
//                startActivity(Intent(this, DashBoardActivity::class.java))
//                finish()
            }
            else {
                Toast.makeText(context, "Please verify your email.",
                    Toast.LENGTH_SHORT).show()
            }
        }
//        else {
//            Toast.makeText(baseContext, "Authentication failed.",
//                Toast.LENGTH_SHORT).show()
////            updateUI(null)
//        }
    }
}