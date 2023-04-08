package com.raion.incareer.data.dummy
data class Job(
    val name: String,
    val company: Company,
    val location: String,
    val jobType: String,
    val salary: String,
    val locationType: String,
    val slot: Int
)
val jobs = listOf(
    Job(
        name = "Software Engineer",
        company = companies[0],
        location = "Jakarta",
        jobType = "Full Time",
        salary = "Negotiable",
        locationType = "Onsite",
        slot = 2
    ),
    Job(
        name = "Data Scientist",
        company = companies[1],
        location = "Bandung",
        jobType = "Full Time",
        salary = "IDR 10.000.000 - 15.000.000",
        locationType = "Hybrid",
        slot = 3
    ),
    Job(
        name = "Mobile App Developer",
        company = companies[2],
        location = "Surabaya",
        jobType = "Part Time",
        salary = "Negotiable",
        locationType = "Remote",
        slot = 1
    ),
    Job(
        name = "UI/UX Designer",
        company = companies[3],
        location = "Yogyakarta",
        jobType = "Full Time",
        salary = "IDR 8.000.000 - 12.000.000",
        locationType = "Onsite",
        slot = 3
    ),
    Job(
        name = "Product Manager",
        company = companies[4],
        location = "Semarang",
        jobType = "Full Time",
        salary = "Negotiable",
        locationType = "Hybrid",
        slot = 5
    ),
    Job(
        name = "Backend Developer",
        company = companies[5],
        location = "Bandung",
        jobType = "Part Time",
        salary = "IDR 5.000.000 - 7.000.000",
        locationType = "Remote",
        slot = 9
    ),
    Job(
        name = "Frontend Developer",
        company = companies[6],
        location = "Jakarta",
        jobType = "Full Time",
        salary = "IDR 7.000.000 - 10.000.000",
        locationType = "Onsite",
        slot = 7
    ),
    Job(
        name = "Data Engineer",
        company = companies[7],
        location = "Surabaya",
        jobType = "Full Time",
        salary = "IDR 12.000.000 - 15.000.000",
        locationType = "Hybrid",
        slot = 8
    ),
    Job(
        name = "QA Engineer",
        company = companies[8],
        location = "Bandung",
        jobType = "Full Time",
        salary = "IDR 6.000.000 - 8.000.000",
        locationType = "Remote",
        slot = 2
    ),
    Job(
        name = "Android Developer",
        company = companies[9],
        location = "Banyuwangi",
        jobType = "Full Time",
        salary = "IDR 10.000.000 - 18.000.000",
        locationType = "Remote",
        slot = 1
    ),
)