package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.BillDTO;
import com.example.cinema_back_end.dtos.TicketDTO;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.kernel.colors.ColorConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PDFService {

    @Autowired
    private TicketService ticketService; // Inject TicketService

    public ByteArrayInputStream generateBillPDF(BillDTO bill) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Load Noto Sans font that supports Vietnamese characters
        PdfFont font = PdfFontFactory.createFont("src/main/resources/fonts/NotoSans-Regular.ttf", PdfEncodings.IDENTITY_H);

        // Add Title
        Paragraph title = new Paragraph("Bill Details")
                .setFont(font)
                .setFontSize(18)
                .setFontColor(ColorConstants.BLACK);
        document.add(title);

        // Define DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Format Created Time
        String formattedCreatedTime = bill.getCreatedTime().format(formatter);

        // Add Table for Bill Details
        Table billTable = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();
        billTable.addCell(new Paragraph("Field").setFont(font));
        billTable.addCell(new Paragraph("Value").setFont(font));

        billTable.addCell(new Paragraph("Bill ID").setFont(font));
        billTable.addCell(new Paragraph(String.valueOf(bill.getId())).setFont(font));

        billTable.addCell(new Paragraph("Created Time").setFont(font));
        billTable.addCell(new Paragraph(formattedCreatedTime).setFont(font));

        billTable.addCell(new Paragraph("Total Price").setFont(font));
        billTable.addCell(new Paragraph(String.valueOf(bill.getPrice())).setFont(font));

        document.add(billTable);

        // Fetch tickets for this bill ID
        List<TicketDTO> tickets = ticketService.getTicketsByBillId(bill.getId());

        // Add Title for Tickets Section
        Paragraph ticketTitle = new Paragraph("Ticket Details")
                .setFont(font)
                .setFontSize(16)
                .setFontColor(ColorConstants.BLACK);
        document.add(ticketTitle);

        // Add Table for Tickets
        Table ticketTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();
        ticketTable.addCell(new Paragraph("Ticket ID").setFont(font));
        ticketTable.addCell(new Paragraph("Showtimes").setFont(font));
        ticketTable.addCell(new Paragraph("Movie Name").setFont(font));
        ticketTable.addCell(new Paragraph("Price").setFont(font));
        ticketTable.addCell(new Paragraph("Chair Name").setFont(font));

        if (tickets != null && !tickets.isEmpty()) {
            for (TicketDTO ticket : tickets) {
                ticketTable.addCell(new Paragraph(String.valueOf(ticket.getId())).setFont(font));

                String showtimes = String.format("%s\n%s",
                        ticket.getSchedule().getStartDate(),
                        ticket.getSchedule().getStartTime());
                ticketTable.addCell(new Paragraph(showtimes).setFont(font));

                // Add Movie Name
                ticketTable.addCell(new Paragraph(ticket.getSchedule().getMovie().getName()).setFont(font));

                ticketTable.addCell(new Paragraph(String.valueOf(ticket.getPrice())).setFont(font));
                ticketTable.addCell(new Paragraph(ticket.getSeat().getName()).setFont(font));
            }
        } else {
            ticketTable.addCell(new Paragraph("No tickets available.").setFont(font));
            ticketTable.addCell(new Paragraph("").setFont(font));
            ticketTable.addCell(new Paragraph("").setFont(font));
            ticketTable.addCell(new Paragraph("").setFont(font));
            ticketTable.addCell(new Paragraph("").setFont(font));
        }

        document.add(ticketTable);
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
