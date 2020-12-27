package am.develop.rssfeed.application.feed.repository

import am.develop.rssfeed.application.feed.data.mocked.MockedRssDataModel

/**
 * Created by Ara Hakobyan on 12/27/2020.
 * Company IDT
 */
class MockedFeedRepository(private val mockedRssDataModel: MockedRssDataModel) {

    fun loadMockedData() = mockedRssDataModel
}