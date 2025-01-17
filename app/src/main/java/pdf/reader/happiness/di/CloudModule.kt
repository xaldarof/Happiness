package pdf.reader.happiness.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.dsl.module
import pdf.reader.happiness.data.cloud.CoinRepository
import pdf.reader.happiness.data.cloud.auth.AuthRepository
import pdf.reader.happiness.data.cloud.data_source.InfoCloudDataSource
import pdf.reader.happiness.data.cloud.data_insert.CloudDataSendService
import pdf.reader.happiness.data.cloud.data_source.TokenCloudDataSource

val cloudModule = module {
    factory<InfoCloudDataSource> { InfoCloudDataSource.Base(get()) }
    factory<CoinRepository> { CoinRepository.Base(get(), get(), get()) }
    factory<DatabaseReference> { FirebaseDatabase.getInstance().getReference("data") }
    factory<TokenCloudDataSource> {
        TokenCloudDataSource.Base(
            FirebaseFirestore.getInstance(),
            get()
        )
    }
    factory<CloudDataSendService> { CloudDataSendService.Base(get()) }

    factory<AuthRepository> { AuthRepository.Base(get()) }

}