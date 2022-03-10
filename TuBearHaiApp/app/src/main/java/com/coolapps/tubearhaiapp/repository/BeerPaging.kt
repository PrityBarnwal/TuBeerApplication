package com.coolapps.tubearhaiapp.repository
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.coolapps.tubearhaiapp.model.BeerResponseItem
import retrofit2.HttpException

class BeerPaging(private val beerRepository: BeerRepository) :PagingSource<Int, BeerResponseItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BeerResponseItem> {

        return try {
            val page = params.key ?: 1
            val response = beerRepository.getAllBeers(page, params.loadSize)
            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null
                else page - 1,
                nextKey = page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)

        }

    }
    override fun getRefreshKey(state: PagingState<Int, BeerResponseItem>): Int? {
        return state.anchorPosition
    }

}