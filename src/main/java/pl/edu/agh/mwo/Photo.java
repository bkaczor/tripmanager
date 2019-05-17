package pl.edu.agh.mwo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Photo {
    private String author;
    private String comment;
    private String date;

    private Photo() { }

    String getAuthor() {
        return author;
    }

    String getComment() {
        return comment;
    }

    String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "author='" + author + '\'' +
                ", comment='" + comment + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    static final class Builder {
        private String author = "";
        private String comment = "";
        private String date = "No date";

        Builder setAuthor(String author) {
            if (author == null)
                return this;
            this.author = author;
            return this;
        }

        Builder addComment(String comment) {
            if (comment == null)
                return this;
            this.comment = comment;
            return this;
        }

        Builder setCurrentDate() {
            LocalDate localDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
            this.date = localDate.format(formatter);
            return this;
        }

        Photo takePhoto() {
            Photo photo = new Photo();
            photo.author = author;
            photo.comment = comment;
            photo.date = date;
            return photo;
        }
    }
}