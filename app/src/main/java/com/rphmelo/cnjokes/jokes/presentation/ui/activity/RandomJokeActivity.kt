package com.rphmelo.cnjokes.jokes.presentation.ui.activity

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.rphmelo.cnjokes.R
import com.rphmelo.cnjokes.common.AppConstant.JOKE_CATEGORY_CODE
import com.rphmelo.cnjokes.common.base.BaseActivity
import com.rphmelo.cnjokes.common.extension.bind
import com.rphmelo.cnjokes.jokes.domain.model.JokeResponse
import com.rphmelo.cnjokes.jokes.presentation.presenter.RandomJokePresenterContract
import com.squareup.picasso.Picasso
import javax.inject.Inject

class RandomJokeActivity : BaseActivity(), RandomJokeViewContract {

    private var category: String? = null
    private val textViewJokeName: TextView by bind(R.id.text_view_joke_name)
    private val textViewJokeUrl: TextView by bind(R.id.text_view_joke_url)
    private val imageViewJokeIcon: ImageView by bind(R.id.image_view_joke_icon)

    @Inject lateinit var randomJokePresenter: RandomJokePresenterContract
    @Inject lateinit var picasso: Picasso

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_joke)
        displayToolbarHomeButton()
        configureDagger()

        randomJokePresenter.attachView(this)

        getExtras()

        category?.apply{
            setTitleToolbar(this)
            randomJokePresenter.getRandomJoke(this)
        }
    }

    override fun fillRandomJoke(jokeResponse: JokeResponse) {
        jokeResponse.run {
            textViewJokeName.text = value
            textViewJokeUrl.text = url

            picasso.load(iconUrl).fit().into(imageViewJokeIcon)
        }
    }

    private fun getExtras(){
        category = intent?.extras?.getString(JOKE_CATEGORY_CODE)
    }
}
