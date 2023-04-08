package com.raion.incareer.presentation.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raion.incareer.R
import com.raion.incareer.data.dummy.Category
import com.raion.incareer.data.dummy.Job


@Composable
fun HomeScreen(
     viewModel: HomeViewModel = HomeViewModel()
) {
    val searchQuery = remember{mutableStateOf(TextFieldValue(""))}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                Brush.verticalGradient(
                    listOf(Color(0XFF1877F2), Color.Transparent),
                    startY = -250f,
                    endY = 650f,

                    )
            )
            .padding(15.dp)

    ) {
        Greeting(viewModel)

        Spacer(modifier = Modifier.height(20.dp))

        WordingNotification()

        Spacer(modifier = Modifier.height(20.dp))

        InsertCV()

        Spacer(modifier = Modifier.height(20.dp))

        SearchBar(searchQuery)

        Title(text = "Kami rangkum untukmu")

        JobListHorizontal(viewModel.getJobs())

        Title(text = "Kategori pekerjaan untukmu")

        CategoryListHorizontal(viewModel.getCategories())

        Spacer(modifier = Modifier.height(20.dp))

        FilterMethod()

        BottomList(viewModel)
    }
}


@Composable
fun BottomList(viewModel: HomeViewModel) {
    Box(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .background(
                Brush.verticalGradient(
                    listOf(Color(0XFF1877F2), Color.Transparent),
                )
            )
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        JobListVertical(jobs = viewModel.getJobs())
    }
}


@Composable
fun Greeting(viewModel: HomeViewModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = viewModel.getUserImage()),
            contentDescription = "user image",
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp),
        )

        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(
                text = "Halo",
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Color(0XFF555353),
                fontSize = 13.sp
            )
            Text(
                text = viewModel.getUserName() + " !",
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Color.Black,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun WordingNotification() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        Text(
            text =
            buildAnnotatedString {
                append("Jangan biarkan")
                pushStyle(SpanStyle(color = Color(0xFF00359E)))
                append(" kesulitan dalam mencari pekerjaan ")
                pop()
                append("menjadi kendala bagi kariermu.")
            },
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 15.sp,
            modifier = Modifier.width(220.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.notification_icon),
            contentDescription = "notification icon",
            modifier = Modifier
                .clickable {
                }
                .size(50.dp),
        )
    }
}

@Composable
fun InsertCV() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .height(50.dp)
                .width(5.dp)
                .background(Color(0XFF00359E))
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Unggah CV Anda untuk mendapatkan prioritas slot & penawaran pekerjaan eksklusif ")
                    pushStyle(
                        SpanStyle(
                            color = Color(0xFF00359E),
                            fontFamily = FontFamily(Font(R.font.poppins_bold))
                        )
                    )
                    append("\nUnggah Sekarang ")
                    pop()
                },
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun Title(text: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ){
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 15.sp,
            color = Color.Black
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SummaryCard(job: Job, onClickItem: ()-> Unit = {}){
    val image by remember { mutableStateOf(job.company.logo)}
    val name by remember { mutableStateOf(job.name)}
    val companyName by remember { mutableStateOf(job.company.name)}
    val jobType by remember { mutableStateOf(job.jobType)}
    val salary by remember { mutableStateOf(job.salary) }
    val slot by remember { mutableStateOf(job.slot) }
    val locationType by remember { mutableStateOf(job.locationType) }

    Card(
        modifier = Modifier
            .padding(0.dp)
            .width(200.dp)
            .height(230.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
        onClick = {onClickItem}
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Person,
                    contentDescription = "orang"
                )
                Spacer(Modifier.width(5.dp))
                Text(
                    text = "$slot slot tersisa",
                    modifier = Modifier
                        .background(
                            color = Color(0XFF93C2FF),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(2.dp),
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "company logo",
                    modifier = Modifier.size(40.dp)
                )
                Image(
                    painter = painterResource(R.drawable.save_icon),
                    contentDescription = "save icon",
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = name,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 13.sp
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = companyName,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 10.sp
                )
                Spacer(Modifier.width(5.dp))
                Image(
                    painter = painterResource(id = R.drawable.verified_icon),
                    contentDescription = "verified icon",
                    modifier = Modifier.size(10.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.position_icon),
                    contentDescription = "position icon",
                    modifier = Modifier.size(18.dp)
                )

                Spacer(Modifier.width(5.dp))

                Text(
                    text = locationType,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 10.sp
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.jobtype_icon),
                    contentDescription = "job type icon",
                    modifier = Modifier.size(18.dp)
                )

                Spacer(Modifier.width(5.dp))

                Text(
                    text = jobType,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 10.sp
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.salary_icon),
                    contentDescription = "salary icon",
                    modifier = Modifier.size(18.dp)
                )

                Spacer(Modifier.width(5.dp))

                Text(
                    text = salary,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Composable
fun SearchBar(searchQuery: MutableState<TextFieldValue>){
    TextField(
        value = searchQuery.value,
        onValueChange = { newText ->
            searchQuery.value = newText
        },
        placeholder = {
            Text(
                text = "Mencari pekerjaan atau perusahaan",
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = Color(0XFF555353),
                fontSize = 13.sp,
            )
        },
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .fillMaxWidth(),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search icon",
                modifier = Modifier
                    .size(20.dp)
                    .wrapContentSize()
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0XFFF0F0F0),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        maxLines = 1
    )
}

@Composable
fun JobListHorizontal(jobs: List<Job>) {
    LazyRow{
        items(jobs.size){index ->
            val aJob = jobs[index]
            SummaryCard(job = aJob)
        }
    }
}

@Composable
fun JobListVertical(jobs: List<Job>) {
    LazyColumn(
        modifier = Modifier.height(1000.dp)
    ){
        items(jobs.size){index ->
            val aJob = jobs[index]
            SummaryCard(job = aJob)
        }
    }
}

@Composable
fun CategoryListHorizontal(categories: List<Category>) {
    val rows = categories.chunked(3)
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        rows.forEach { row ->
            Row {
                row.forEach { category ->
                    CategoryCard(category)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryCard(category: Category, onClickItem: ()-> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .width(110.dp)
            .height(100.dp),
        elevation = 20.dp,
        shape = RoundedCornerShape(20.dp),
        onClick = {onClickItem}
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = category.title,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 12.sp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ){
                Image(
                    painter = painterResource(id = category.icon),
                    contentDescription = "category icon",
                    Modifier.size(35.dp)
                )
            }
        }
    }
}


@Composable
fun FilterMethod() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
    ){
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.filter_icon),
                contentDescription = "filter icon",
                modifier = Modifier.size(12.dp)
            )

            Spacer(modifier = Modifier.width(3.dp))

            Text(
                text = "Filter",
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                fontSize = 10.sp
            )
        }
        
        FilterButton(text = "Remote")

        FilterButton(text = "Full Time")

        FilterButton(text = "1-3 YoE")
    }
}

@Composable
fun FilterButton(text: String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            fontSize = 10.sp
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun JobCard(job: Job, onClickItem: ()-> Unit = {}){

    val image by remember { mutableStateOf(job.company.logo)}
    val name by remember { mutableStateOf(job.name)}
    val companyName by remember { mutableStateOf(job.company.name)}
    val jobType by remember { mutableStateOf(job.jobType)}
    val salary by remember { mutableStateOf(job.salary) }
    val slot by remember { mutableStateOf(job.slot) }
    val locationType by remember { mutableStateOf(job.locationType) }
    
    Card(
        modifier = Modifier
            .padding(0.dp)
            .width(200.dp)
            .height(230.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
        onClick = {onClickItem}
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Person,
                    contentDescription = "orang"
                )
                Spacer(Modifier.width(5.dp))
                Text(
                    text = "$slot slot tersisa",
                    modifier = Modifier
                        .background(
                            color = Color(0XFF93C2FF),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(2.dp),
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "company logo",
                    modifier = Modifier.size(40.dp)
                )
                Image(
                    painter = painterResource(R.drawable.save_icon),
                    contentDescription = "save icon",
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = name,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 13.sp
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = companyName,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 10.sp
                )
                Spacer(Modifier.width(5.dp))
                Image(
                    painter = painterResource(id = R.drawable.verified_icon),
                    contentDescription = "verified icon",
                    modifier = Modifier.size(10.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.position_icon),
                    contentDescription = "position icon",
                    modifier = Modifier.size(18.dp)
                )

                Spacer(Modifier.width(5.dp))

                Text(
                    text = locationType,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 10.sp
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.jobtype_icon),
                    contentDescription = "job type icon",
                    modifier = Modifier.size(18.dp)
                )

                Spacer(Modifier.width(5.dp))

                Text(
                    text = jobType,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 10.sp
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.salary_icon),
                    contentDescription = "salary icon",
                    modifier = Modifier.size(18.dp)
                )

                Spacer(Modifier.width(5.dp))

                Text(
                    text = salary,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 10.sp
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPrev() {
    HomeScreen()
}
