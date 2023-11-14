class FileDownloaderProxy implements Downloader {
    private FileDownloader fileDownloader;

    public FileDownloaderProxy() {
        // Khởi tạo FileDownloader với User-Agent của trình duyệt FireFox
        this.fileDownloader = new FileDownloader("Mozilla Firefox");
    }

    @Override
    public void download(String url) {
        // Chuyển lời gọi đến phương thức download() của đối tượng FileDownloader
        fileDownloader.download(url);
    }
}