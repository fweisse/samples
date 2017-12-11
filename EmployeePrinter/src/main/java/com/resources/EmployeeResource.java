package com.resources;


import com.json.PrintableEmployee;
import com.json.PrintableEmployees;
import com.service.EmployeeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.IntStream;

@Path("employee")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private EmployeeService service;
    final String emptyColumn = "<td></td>";

    public EmployeeResource(EmployeeService service) {
        this.service = service;
    }

    @GET
    public PrintableEmployees getEmployeesForPrint() {
        return service.getPrintablesEMployees();
    }

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public Response getEmployeesHtml() {
        return Response.ok(getHtmlTable(service.getPrintablesEMployees()) ).build();
    }

    private String getHtmlTable(PrintableEmployees employees) {
        StringBuilder table = new StringBuilder("<table border=\"1\">");
        employees.getEmployess().forEach(
                empl -> table.append(getHtmlRow(empl, employees.getColumnCount())));
        return table
                .append("</table>")
                .toString();
    }

    private String getHtmlRow(PrintableEmployee employee, int columns) {
        StringBuilder row = new StringBuilder("<tr>");
        IntStream.range(0, employee.getColumnPos())
                .forEach(i ->row.append(emptyColumn));
        row
                .append("<td>" + employee.getName() + "</td>");
        IntStream.range(employee.getColumnPos(), columns -1)
                .forEach(i ->row.append(emptyColumn));
        return row
                .append("</tr>")
                .toString();
    }



}
