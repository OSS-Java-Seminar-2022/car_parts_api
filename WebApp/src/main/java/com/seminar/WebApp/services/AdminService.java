package com.seminar.WebApp.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.seminar.WebApp.entities.Car;
import com.seminar.WebApp.entities.Image;
import com.seminar.WebApp.entities.Issue;
import com.seminar.WebApp.entities.Part;


@Service
public class AdminService {
    
    @Autowired
    RestTemplate restTemplate;

    public String admin(Model model)
    {
        model.addAttribute("car",new Car());
        model.addAttribute("issue", new Issue());
        model.addAttribute("part", new Part());

        ResponseEntity<List<Part>> partsResponse = restTemplate.exchange("http://localhost:8080/parts",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Part>>(){});
        List<Part> parts = partsResponse.getBody();

        ResponseEntity<List<Issue>> issueResponse = restTemplate.exchange("http://localhost:8080/issues",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Issue>>(){});
        List<Issue> issues = issueResponse.getBody();

        ResponseEntity<List<Car>> carsResponse = restTemplate.exchange("http://localhost:8080/cars",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Car>>(){});
        List<Car> cars = carsResponse.getBody();
        model.addAttribute("cars",cars);
        model.addAttribute("issues",issues);
        model.addAttribute("parts",parts);

        return "admin";
    }

    public String carsList(int pageNo, int pageSize, String sort, Model model)
    {
        pageNo = pageNo < 0 ? 0 : pageNo;
        pageSize = pageSize < 1 ? 1 : pageSize;
        sort = sort == null ? "id" : sort;
        ResponseEntity<List<Car>> carsResponse = restTemplate.exchange("http://localhost:8080/carspage?pageNo="+pageNo+
        "&pageSize="+pageSize+"&sort="+sort,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Car>>(){});
        List<Car> cars = carsResponse.getBody();
        model.addAttribute("cars",cars);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("sort", sort);


        return "cars";
    }

    public String issueList(int pageNo, int pageSize, String sort, Model model)
    {
        pageNo = pageNo <= 0 ? 0 : pageNo;
        pageSize = pageSize <= 1 ? 1 : pageSize;
        sort = sort == null ? "id" : sort;
        ResponseEntity<List<Issue>> issueResponse = restTemplate.exchange("http://localhost:8080/issuespage?pageNo="+pageNo+
        "&pageSize="+pageSize+"&sort="+sort,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Issue>>(){});
        List<Issue> issues = issueResponse.getBody();
        model.addAttribute("issues",issues);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("sort", sort);


        return "issues";
    }

    public String partList(int pageNo, int pageSize, String sort, Model model)
    {
        pageNo = pageNo <= 0 ? 0 : pageNo;
        pageSize = pageSize <= 1 ? 1 : pageSize;
        sort = sort == null ? "id" : sort;
        ResponseEntity<List<Part>> partResponse = restTemplate.exchange("http://localhost:8080/partspage?pageNo="+pageNo+
        "&pageSize="+pageSize+"&sort="+sort,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Part>>(){});
        List<Part> parts = partResponse.getBody();

        model.addAttribute("parts",parts);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("sort", sort);


        return "parts";
    }





    public RedirectView carAdded(Car car)
    {
        restTemplate.postForObject("http://localhost:8080/cars", car,Car.class);
        return new RedirectView("/admin");
    }

    public RedirectView issueAdded(Issue issue)
    {
        restTemplate.postForObject("http://localhost:8080/issues", issue,Issue.class);
        return new RedirectView("/admin");
    }

    public RedirectView partAdded(Part part,MultipartFile img) throws IOException
    {
        Image image = new Image();
        image.setName(img.getOriginalFilename());
        image.setData(img.getBytes());
        part.setImage(image);
        restTemplate.postForObject("http://localhost:8080/parts", part,Part.class);
        return new RedirectView("/admin");
    }

    public RedirectView addIssuesToParts(int partSelect,String issues)
    {
        String[] strings = issues.split(",",0);
        for(String issueID: strings)
        {
            Issue addedIssue = new Issue();
            try
            {
            restTemplate.postForObject("http://localhost:8080/parts/" + partSelect + "/issues/" + issueID,addedIssue,Issue.class);
            }
            catch(Exception e)
            {
                continue;
            }
        }
        
        return new RedirectView("/admin");
    }

    public RedirectView addCarsToParts(int partSelect,String cars)
    {
        String[] strings = cars.split(",",0);
        for(String carID: strings)
        {
            Car addedCar = new Car();
            try
            {
                restTemplate.postForObject("http://localhost:8080/parts/" + partSelect + "/cars/" + carID,addedCar, Car.class);
            }
            catch(Exception e)
            {
                continue;
            }
        }
        
        return new RedirectView("/admin");
    }

}
