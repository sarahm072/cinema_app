import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cinema.Componenets.MovieCard
import androidx.compose.ui.unit.dp
import com.example.cinema.Componenets.Movie
import java.time.DayOfWeek


@Composable
fun MovieGrid(movies: List<Movie>) {
    val daysOfWeek = DayOfWeek.values()
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // عرض الأفلام في أعمدة
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(movies.size) { index ->
            MovieCard(movie = movies[index])
        }
    }
}
