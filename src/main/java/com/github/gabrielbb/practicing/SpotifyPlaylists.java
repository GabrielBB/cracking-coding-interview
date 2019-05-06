package com.github.gabrielbb.practicing;

public class SpotifyPlaylists {

    public static int getPermutations(int songs, int playlistMaxSongs, int playlistMaxSongRepetition) {

        return (factorial(songs) / (factorial(songs - playlistMaxSongs))) / factorial(playlistMaxSongs);
    }

    private static int factorial(int n) {

        for (int i = n; i > 1; i--) {
            n *= (i - 1);
        }

        return n;
    }
}