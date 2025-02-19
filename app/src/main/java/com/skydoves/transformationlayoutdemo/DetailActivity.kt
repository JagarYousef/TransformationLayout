/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.transformationlayoutdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.skydoves.transformationlayout.TransformationAppCompatActivity
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout
import com.skydoves.transformationlayoutdemo.recycler.Poster
import kotlinx.android.synthetic.main.activity_detail.detail_description
import kotlinx.android.synthetic.main.activity_detail.detail_title
import kotlinx.android.synthetic.main.activity_detail.profile_detail_background

class DetailActivity : TransformationAppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    intent.getParcelableExtra<Poster>(posterExtraName)?.let {
      Glide.with(this)
        .load(it.poster)
        .into(profile_detail_background)
      detail_title.text = it.name
      detail_description.text = it.description
    }
  }

  companion object {
    const val posterExtraName = "posterExtraName"
    fun startActivity(
      context: Context,
      transformationLayout: TransformationLayout,
      poster: Poster
    ) {
      val intent = Intent(context, DetailActivity::class.java)
      intent.putExtra(posterExtraName, poster)
      TransformationCompat.startActivity(transformationLayout, intent)
    }
  }
}
