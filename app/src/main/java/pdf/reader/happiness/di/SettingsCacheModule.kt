package pdf.reader.happiness.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module
import pdf.reader.happiness.data.settings_cache.*
import pdf.reader.happiness.presentation.MainFragmentPresenter
import pdf.reader.happiness.presentation.MainPresenter
import pdf.reader.happiness.presentation.ReadingActivityPresenter
import pdf.reader.happiness.presentation.fragments.MainFragment
import pdf.reader.happiness.tools.CacheClear


@OptIn(KoinApiExtension::class)
val settingsCacheModule = module {
    factory<SharedPreferences> {
        androidContext().getSharedPreferences(
            "cache",
            Context.MODE_PRIVATE
        )
    }

    factory<ThemeController> { ThemeController.Base(get()) }
    factory<FontController> { FontController.Base(get()) }
    factory<CongratulationController> { CongratulationController.Base(get()) }
    factory<ReadingActivityPresenter> { ReadingActivityPresenter(get(), get()) }

    factory<CacheClear> { CacheClear.Base(get(), get(), get(), get(),get()) }

    factory<BadgeController> { BadgeController.Base(get()) }
    factory<WastedTimeController> { WastedTimeController.Base(get()) }
}