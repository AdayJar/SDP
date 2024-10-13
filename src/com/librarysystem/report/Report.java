package src.com.librarysystem.report;

import java.time.LocalDate;
//Builder
public class Report {
    private final String reportTitle;
    private final String reportContent;
    private final LocalDate creationDate; 

    private Report(ReportBuilder builder) {
        this.reportTitle = builder.reportTitle;
        this.reportContent = builder.reportContent;
        this.creationDate = builder.creationDate; 
    }

    public static class ReportBuilder {
        private String reportTitle;
        private String reportContent;
        private LocalDate creationDate; 

        public ReportBuilder setTitle(String title) {
            this.reportTitle = title;
            return this;
        }

        public ReportBuilder setContent(String content) {
            this.reportContent = content;
            return this;
        }

        public ReportBuilder setCreationDate(LocalDate date) {
            this.creationDate = date; 
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }

    @Override
    public String toString() {
        return "Report{" +
                "title='" + reportTitle + '\'' +
                ", content='" + reportContent + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
