package jp.techacademy.hirotaka.iwasaki.jumpactiongame

import com.badlogic.gdx.graphics.Texture

class Enemy(type: Int, texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
    : GameObject(texture, srcX, srcY, srcWidth, srcHeight) {

    companion object {
        // 横幅、高さ
        val ENEMY_WIDTH = 1.0f
        val ENEMY_HEIGHT = 1.0f

        // タイプ（通常と動くタイプ）
        val ENEMY_TYPE_STATIC = 0
        val ENEMY_TYPE_MOVING = 1

        // 速度
        val ENEMY_VELOCITY = -2.0f
    }

    var mType: Int

    init {
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT)
        mType = type
        if (mType == ENEMY_TYPE_MOVING) {
            velocity.y = ENEMY_VELOCITY
        }
    }


    // 座標を更新する
    fun update(deltaTime: Float) {
        if (mType == ENEMY_TYPE_MOVING) {
            //y += velocity.y * deltaTime % GameScreen.WORLD_HEIGHT // 下まで行くと上に戻る

            y += velocity.y * deltaTime
            if (y < 0) { // 下まで行くと上に戻る
                y = GameScreen.WORLD_HEIGHT.toFloat()
            }
        }
    }
}