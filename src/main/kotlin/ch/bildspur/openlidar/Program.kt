package ch.bildspur.openlidar

import ch.bildspur.openlidar.controller.PrimaryController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * Created by cansik on 04.02.17.
 */
class Program : Application() {

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val loader = FXMLLoader(javaClass.classLoader.getResource("PrimaryView.fxml"))
        val root = loader.load<Any>() as Parent
        val controller = loader.getController<Any>() as PrimaryController

        controller.primaryStage = primaryStage

        primaryStage.title = "$NAME - $VERSION"
        primaryStage.scene = Scene(root)

        // setup on shown event
        primaryStage.setOnShown { controller.setupView() }
        primaryStage.isResizable = false

        primaryStage.setOnShown { controller.setupView() }
        primaryStage.setOnCloseRequest {
            System.exit(0)
        }

        primaryStage.show()
    }

    companion object {
        @JvmStatic
        val NAME = "Open LIDAR Scanner"

        @JvmStatic
        val VERSION = "0.1"

        @JvmStatic
        fun main(args: Array<String>) {
            launch(Program::class.java)
        }
    }
}