package com.example.fabio.moviefinder.tmdbService;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class FakeTMDBService implements TMDBService {
    @Override
    public String getBaseUrlForImages() {
        return "https://image.tmdb.org/t/p/w500";
    }

    @Override
    public MovieListModel getUpcomingMovies(Integer page) {
        List<MovieListingModel> upcomingMovies = getAllUpcomingMovies();

        return new MovieListModel(
            page,
            upcomingMovies,
            1,
            upcomingMovies.size()
        );
    }

    @Override
    public MovieDetailsModel getMovieDetails(Integer movieId) {
        return getFightClubMovieModel();
    }

    @Override
    public MovieListModel searchMoviesByTitle(String query) {
        List<MovieListingModel> upcomingMovies = getAllUpcomingMovies();

        ArrayList<MovieListingModel> filtered = new ArrayList<>();
        for (MovieListingModel m : upcomingMovies) {
            if (m.getTitle().contains(query) || m.getOriginalTitle().contains(query)) {
                filtered.add(m);
            }
        }

        return new MovieListModel(
            0,
            filtered,
            1,
            filtered.size()
        );
    }

    @NonNull
    private MovieDetailsModel getFightClubMovieModel() {
        ArrayList<MovieGenreModel> genres = new ArrayList<>();
        genres.add(new MovieGenreModel(18, "Drama"));

        ArrayList<ProductionCompanyModel> prodCompanies = new ArrayList<>();
        prodCompanies.add(new ProductionCompanyModel(
            "Regency Enterprises",
            508,
            "/7PzJdsLGlR7oW4J0J5Xcd0pHGRg.png",
            "US"
        ));
        prodCompanies.add(new ProductionCompanyModel(
            "Fox 2000 Pictures",
            711,
            null,
            ""
        ));
        prodCompanies.add(new ProductionCompanyModel(
            "Taurus Film",
            20555,
            null,
            ""
        ));

        ArrayList<ProductionCountryModel> prodCountries = new ArrayList<>();
        prodCountries.add(new ProductionCountryModel(
            "US",
            "United States of America"
        ));

        ArrayList<LanguageModel> spokenLanguages = new ArrayList<>();
        spokenLanguages.add(new LanguageModel(
            "en",
            "English"
        ));

        return new MovieDetailsModel(
            false,
            "/87hTDiay2N2qWyX4Ds7ybXi9h8I.jpg",
            63000000,
            genres,
            "",
            550,
            "tt0137523",
            "en",
            "Fight Club",
            "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
            0.5,
            null,
            prodCompanies,
            prodCountries,
            "1999-10-12",
            100853753,
            139,
            spokenLanguages,
            "Released",
            "How much can you know about yourself if you've never been in a fight?",
            "Fight Club",
            false,
            7.8,
            3439
        );
    }

    @NonNull
    private List<MovieListingModel> getAllUpcomingMovies() {
        ArrayList<MovieListingModel> upcomingMovies = new ArrayList<>();
        upcomingMovies.add(getUpcomingMovie0());
        upcomingMovies.add(getUpcomingMovie1());
        upcomingMovies.add(getUpcomingMovie2());
        upcomingMovies.add(getUpcomingMovie3());
        upcomingMovies.add(getUpcomingMovie4());
        upcomingMovies.add(getUpcomingMovie5());
        upcomingMovies.add(getUpcomingMovie6());
        upcomingMovies.add(getUpcomingMovie7());
        upcomingMovies.add(getUpcomingMovie8());
        upcomingMovies.add(getUpcomingMovie9());
        return upcomingMovies;
    }

    @NonNull
    private MovieListingModel getUpcomingMovie0() {
        return new MovieListingModel(
            "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg",
            false,
            "A lighthouse keeper and his wife living off the coast of Western Australia raise a baby they rescue from an adrift rowboat.",
            "2016-09-02",
            null,
            283552,
            "The Light Between Oceans",
            "en",
            "The Light Between Oceans",
            "/2Ah63TIvVmZM3hzUwR5hXFg2LEk.jpg",
            4.546151,
            11,
            false,
            4.41);
    }

    @NonNull
    private MovieListingModel getUpcomingMovie1() {
        return new MovieListingModel(
            "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg",
            false,
            "Friends hatch a plot to retrieve a stolen cat by posing as drug dealers for a street gang.",
            "2016-09-14",
            null,
            342521,
            "Keanu",
            "en",
            "Keanu",
            "/scM6zcBTXvUByKxQnyM11qWJbtX.jpg",
            3.51555,
            97,
            false,
            6.04);
    }

    @NonNull
    private MovieListingModel getUpcomingMovie2() {
        return new MovieListingModel(
            "/1BdD1kMK1phbANQHmddADzoeKgr.jpg",
            false,
            "On January 15, 2009, the world witnessed the \"Miracle on the Hudson\" when Captain \"Sully\" Sullenberger glided his disabled plane onto the frigid waters of the Hudson River, saving the lives of all 155 aboard. However, even as Sully was being heralded by the public and the media for his unprecedented feat of aviation skill, an investigation was unfolding that threatened to destroy his reputation and his career.",
            "2016-09-08",
            null,
            363676,
            "Sully",
            "en",
            "Sully",
            "/nfj8iBvOjlb7ArbThO764HCQw5H.jpg",
            3.254896,
            8,
            false,
            4.88);
    }

    @NonNull
    private MovieListingModel getUpcomingMovie3() {
        return new MovieListingModel(
            "/2gd30NS4RD6XOnDlxp7nXYiCtT1.jpg",
            false,
            "The fates of Henry - an American correspondent - and Teresa, one of the Republic's censors during the Spanish Civil War.",
            "2016-09-09",
            null,
            363841,
            "Guernika",
            "en",
            "Guernica",
            "/abuvTNGs7d05C3OdYdmPqZLEFpY.jpg",
            3.218451,
            9,
            false,
            4.61);
    }

    @NonNull
    private MovieListingModel getUpcomingMovie4() {
        return new MovieListingModel(
            "/ag6NsqD8tpDGgAcs4CnfdI3miSD.jpg",
            false,
            "Louis, a terminally ill writer, returns home after a long absence to tell his family that he is dying.",
            "2016-09-01",
            null,
            338189,
            "Juste la fin du monde",
            "fr",
            "It's Only the End of the World",
            "/ngCkX82tbmMXQ2DhP9vqZbtSume.jpg",
            2.995961,
            11,
            false,
            5.23);
    }

    @NonNull
    private MovieListingModel getUpcomingMovie5() {
        return new MovieListingModel(
            "/kqmGs9q5WZkxKub60K6pU37GdvU.jpg",
            false,
            "A college student ventures with a group of friends into the Black Hills Forest in Maryland to uncover the mystery surrounding the disappearance of his sister years earlier, which many believe is connected to the legend of the Blair Witch. At first the group is hopeful, especially when a pair of locals offer to act as guides through the dark and winding woods, but as the endless night wears on, the group is visited by a menacing presence. Slowly, they begin to realize the legend is all too real and more sinister than they could have imagined.",
            "2016-09-16",
            null,
            351211,
            "Blair Witch",
            "en",
            "Blair Witch",
            "/njj4Zk1ZEMNVvSO68BHHRHgqkcv.jpg",
            2.877025,
            5,
            false,
            1.9);
    }

    @NonNull
    private MovieListingModel getUpcomingMovie6() {
        return new MovieListingModel(
            "/zn3mchTeqXrSCJBpHsbS68HozWZ.jpg",
            false,
            "A big screen remake of John Sturges' classic western The Magnificent Seven, itself a remake of Akira Kurosawa's Seven Samurai. Seven gun men in the old west gradually come together to help a poor village against savage thieves.",
            "2016-09-22",
            null,
            333484,
            "The Magnificent Seven",
            "en",
            "The Magnificent Seven",
            "/g54J9MnNLe7WJYVIvdWTeTIygAH.jpg",
            2.652445,
            8,
            false,
            3.94);
    }

    @NonNull
    private MovieListingModel getUpcomingMovie7() {
        return new MovieListingModel(
            "/a4qrfP2fVWqasbUUdKCwjDGCTTM.jpg",
            false,
            "Breaking up with Mark Darcy leaves Bridget Jones over 40 and single again. Feeling that she has everything under control, Jones decides to focus on her career as a top news producer. Suddenly, her love life comes back from the dead when she meets a dashing and handsome American named Jack. Things couldn't be better, until Bridget discovers that she is pregnant. Now, the befuddled mom-to-be must figure out if the proud papa is Mark or Jack.",
            "2016-09-15",
            null,
            95610,
            "Bridget Jones's Baby",
            "en",
            "Bridget Jones's Baby",
            "/u81y11sFzOIHdduSrrajeHOaCbU.jpg",
            2.56718,
            8,
            false,
            4.81);
    }

    @NonNull
    private MovieListingModel getUpcomingMovie8() {
        return new MovieListingModel(
            "/39ia8d9HPZlnYuEX5w2Gk25Tpgs.jpg",
            false,
            "Morgan is about a corporate risk-management consultant who has to decide and determine whether or not to terminate an artificial being's life that was made in a laboratory environment.",
            "2016-09-02",
            null,
            377264,
            "Morgan",
            "en",
            "Morgan",
            "/j8h0zfecahJlamSle54UP3AP2k3.jpg",
            2.351093,
            6,
            false,
            6.75);
    }

    @NonNull
    private MovieListingModel getUpcomingMovie9() {
        return new MovieListingModel(
            "/jMRRPpUlDrCGWlMWJ1cuSANcgTP.jpg",
            false,
            "A psychologist who begins working with a young boy who has suffered a near-fatal fall finds himself drawn into a mystery that tests the boundaries of fantasy and reality.",
            "2016-09-01",
            null,
            294795,
            "The 9th Life of Louis Drax",
            "en",
            "The 9th Life of Louis Drax",
            "/yoHlRFkgcP5AbaFpyanmEhe21Dn.jpg",
            2.260147,
            2,
            false,
            1.0);
    }
}
