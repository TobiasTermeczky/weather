package nl.yzaazy.weather.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import nl.yzaazy.weather.R
import nl.yzaazy.weather.app.DataCallback
import nl.yzaazy.weather.app.WeatherPersistence
import nl.yzaazy.weather.model.WeatherData

/**
 * Implementation of App Widget functionality.
 */
class WeatherWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            val weatherPersistence = WeatherPersistence()
            weatherPersistence.getData(context, object: DataCallback {
                override fun dataCallback(weatherData: WeatherData) {
                    updateAppWidget(context, appWidgetManager, appWidgetId, weatherData)
                }
            })
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    companion object {

        internal fun updateAppWidget(
            context: Context, appWidgetManager: AppWidgetManager,
            appWidgetId: Int, weatherData: WeatherData
        ) {
            val views = RemoteViews(context.packageName, R.layout.weather_widget)
            views.setTextViewText(R.id.weather_summery_text, weatherData.currently.summary)
            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}

